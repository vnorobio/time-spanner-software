package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    private final MockMvc mockMvc;

    private static final String USER_JSON = "{ \"id\": 1, \"login\": \"string\", \"password\": \"string\", \"name\": \"string\", \"email\": \"string\", \"active\": 0}";

    @InjectMocks
    private UserController controller;

    @MockBean
    private UserService service;

    @Autowired
    public UserControllerTest(MockMvc mockMvc, UserController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }

    @Test
    void findAll() throws Exception{

        // given
        UserEntity user1 = new UserEntity(1L, "howtodoinjava", "Lokesh", "Gupta", "howtodoinjava@gmail.com",true);
        UserEntity user2 = new UserEntity(2L, "java", "Gupta", "Lokesh", "Lokeshjava@gmail.com",true);
        List<UserEntity> users = Arrays.asList(user1,user2);

        given(service.findAll()).willReturn(users);

        // when
        ResponseEntity<List<UserEntity>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/user/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());


    }

   @Test
    void finById() throws Exception{
       UserEntity user1 = new UserEntity(2L, "howtodoinjava", "Lokesh", "Gupta", "howtodoinjava@gmail.com",true);
       given(service.findById(2L)).willReturn(Optional.of(user1));

       ResponseEntity<UserEntity> responseEntity = controller.finById(2L);

       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/user/id/{id}",2))
               .andExpect(status().isOk())
               .andReturn();

       assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void finByLogin() throws Exception{
        UserEntity user1 = new UserEntity(2L, "howtodoinjava", "Lokesh", "Gupta", "howtodoinjava@gmail.com",true);
        given(service.findByLogin("howtodoinjava")).willReturn(Optional.of(user1));

        ResponseEntity<UserEntity> responseEntity = controller.findByLogin("howtodoinjava");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/user/login/{login}","howtodoinjava"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finByEmail() throws Exception{
        UserEntity user1 = new UserEntity(2L, "howtodoinjava", "Lokesh", "Gupta", "howtodoinjava@gmail.com",true);
        given(service.findByEmail("howtodoinjava@gmail.com")).willReturn(Optional.of(user1));

        ResponseEntity<UserEntity> responseEntity = controller.findByEmail("howtodoinjava@gmail.com");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/user/email/{email}","howtodoinjava@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/user/").content(USER_JSON)
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
               .andReturn();

       assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        UserEntity user1 = new UserEntity(1L, "howtodoinjava", "Lokesh", "Gupta", "howtodoinjava@gmail.com",true);
        given(service.findById(1L)).willReturn(Optional.of(user1));
        given(service.update(user1)).willReturn(user1);

        ResponseEntity<UserEntity> responseEntity = controller.update(user1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/catalogs/v1/user/").content(USER_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void delete() throws Exception  {
        UserEntity user1 = new UserEntity(1L, "howtodoinjava", "Lokesh", "Gupta", "howtodoinjava@gmail.com",true);
        given(service.existsById(1L)).willReturn(Boolean.TRUE);
        doNothing().when(service).delete(1L);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/catalogs/v1/user/{id}",1))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }

}