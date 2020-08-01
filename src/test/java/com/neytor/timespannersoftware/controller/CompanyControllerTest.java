package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Company;
import com.neytor.timespannersoftware.model.CompanyEntity;
import com.neytor.timespannersoftware.service.CompanyService;
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
@WebMvcTest(controllers = CompanyController.class)
public class CompanyControllerTest {

    private final MockMvc mockMvc;

    private static final String PROJECT_JSON = "{ \"id\": 1, \"description\": \"descripcion1\"}";

    @InjectMocks
    private CompanyController controller;

    @MockBean
    private CompanyService service;

    @Autowired
    public CompanyControllerTest(MockMvc mockMvc, CompanyController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }

    @Test
    void findAll() throws Exception{
        // given
        CompanyEntity entity1 = new CompanyEntity();
        CompanyEntity entity2 = new CompanyEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findAll()).willReturn(entities);

        // when
        ResponseEntity<List<Company>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/company/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finById() throws Exception{
        CompanyEntity entity1 = new CompanyEntity(1L,"descripcion" );
        given(service.findById(2L)).willReturn(Optional.of(entity1));

        ResponseEntity<Company> responseEntity = controller.finById(2L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/company/id/{id}",2))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void findByDescription() throws Exception{
        CompanyEntity entity1 = new CompanyEntity(1L,"descripcion1" );
        CompanyEntity entity2 = new CompanyEntity(2L,"descripcion2" );
        List entities = Arrays.asList(entity1,entity2);
        given(service.findByDescriptionContaining("descripcion")).willReturn(entities);

        ResponseEntity<List<Company>> response = (controller.findByDescription("descripcion"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/company/description/{description}","descripcion"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
        CompanyEntity entity1 = new CompanyEntity(1L,"descripcion1" );
        given(service.create(any(CompanyEntity.class))).willReturn(entity1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/company/").content(PROJECT_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        CompanyEntity entity1 = new CompanyEntity(1L,"descripcion1" );
        Company companyDto = new Company(1L,"descripcion1" );
        given(service.findById(1L)).willReturn(Optional.of(entity1));
        given(service.update(entity1)).willReturn(entity1);

        ResponseEntity<Company> responseEntity = controller.update(companyDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/catalogs/v1/company/").content(PROJECT_JSON)
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
                .delete("/catalogs/v1/company/{id}",1))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}
