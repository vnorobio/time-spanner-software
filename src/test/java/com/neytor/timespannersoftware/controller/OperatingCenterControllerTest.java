package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.OperatingCenter;
import com.neytor.timespannersoftware.model.OperatingCenterEntity;
import com.neytor.timespannersoftware.service.OperatingCenterService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OperatingCenterController.class)
public class OperatingCenterControllerTest {

    private final MockMvc mockMvc;

    private static final String OPERATING_CENTER_JSON = "{ \"id\": 1, \"code\": \"codigo1\", \"description\": \"descripcion1\"}";

    @InjectMocks
    private OperatingCenterController controller;

    @MockBean
    private OperatingCenterService service;

    @Autowired
    public OperatingCenterControllerTest(MockMvc mockMvc, OperatingCenterController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }

    @Test
    void findAll() throws Exception{
        // given
        OperatingCenterEntity entity1 = new OperatingCenterEntity();
        OperatingCenterEntity entity2 = new OperatingCenterEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findAll()).willReturn(entities);

        // when
        ResponseEntity<List<OperatingCenter>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/operating_center/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finById() throws Exception{
        OperatingCenterEntity entity1 = new OperatingCenterEntity(1L,"codigo","descripcion" );
        given(service.findById(2L)).willReturn(Optional.of(entity1));

        ResponseEntity<OperatingCenter> responseEntity = controller.finById(2L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/operating_center/id/{id}",2))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void findByDescription() throws Exception{
        OperatingCenterEntity entity1 = new OperatingCenterEntity(1L,"codigo1","descripcion1" );
        OperatingCenterEntity entity2 = new OperatingCenterEntity(2L,"codigo2","descripcion2" );
        List entities = Arrays.asList(entity1,entity2);
        given(service.findByDescriptionContaining("descripcion")).willReturn(entities);

        ResponseEntity<List<OperatingCenter>> response = (controller.findByDescription("descripcion"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/operating_center/description/{description}","descripcion"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
        OperatingCenterEntity entity1 = new OperatingCenterEntity(1L,"codigo1","descripcion1" );
        given(service.create(any(OperatingCenterEntity.class))).willReturn(entity1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/operating_center/").content(OPERATING_CENTER_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        OperatingCenterEntity entity1 = new OperatingCenterEntity(1L,"codigo1","descripcion1" );
        OperatingCenter operatingCenterDto = new OperatingCenter(1L,"codigo1","descripcion1" );
        given(service.findById(1L)).willReturn(Optional.of(entity1));
        given(service.update(entity1)).willReturn(entity1);

        ResponseEntity<OperatingCenter> responseEntity = controller.update(operatingCenterDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/catalogs/v1/operating_center/").content(OPERATING_CENTER_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void delete() throws Exception  {
        given(service.existsById(1L)).willReturn(Boolean.TRUE);
        doNothing().when(service).delete(1L);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/catalogs/v1/operating_center/{id}",1))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}
