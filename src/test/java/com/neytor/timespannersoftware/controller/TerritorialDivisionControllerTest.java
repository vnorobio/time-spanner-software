package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.TerrirorialDivision;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.TerritorialDivisionEntity;
import com.neytor.timespannersoftware.service.TerritorialDivisionService;
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
@WebMvcTest(controllers = TerritorialDivisionController.class)
public class TerritorialDivisionControllerTest {

    private final MockMvc mockMvc;

    private static final String BUSINESSUNIT_JSON = "{ \"id\": 1, \"code\": \"codigo1\", \"description\": \"descripcion1\"}";

    @InjectMocks
    private TerritorialDivisionController controller;

    @MockBean
    private TerritorialDivisionService service;

    @Autowired
    public TerritorialDivisionControllerTest(MockMvc mockMvc, TerritorialDivisionController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }

    @Test
    void findAll() throws Exception{
        // given
        TerritorialDivisionEntity entity1 = new TerritorialDivisionEntity();
        TerritorialDivisionEntity entity2 = new TerritorialDivisionEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findAll()).willReturn(entities);

        // when
        ResponseEntity<List<TerrirorialDivision>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/business_unit/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finById() throws Exception{
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        TerritorialDivisionEntity entity1 = new TerritorialDivisionEntity(1L,"codigo","descripcion" , countryEntity, 1);
        given(service.findById(2L)).willReturn(Optional.of(entity1));

        ResponseEntity<TerrirorialDivision> responseEntity = controller.finById(2L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/business_unit/id/{id}",2))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void findByDescription() throws Exception{
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        TerritorialDivisionEntity entity1 = new TerritorialDivisionEntity(1L,"codigo1","descripcion1" , countryEntity,1);
        TerritorialDivisionEntity entity2 = new TerritorialDivisionEntity(2L,"codigo2","descripcion2" , countryEntity, 1);
        List entities = Arrays.asList(entity1,entity2);
        given(service.findByDescriptionContaining("descripcion")).willReturn(entities);

        ResponseEntity<List<TerrirorialDivision>> response = (controller.findByDescription("descripcion"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/business_unit/description/{description}","descripcion"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        TerritorialDivisionEntity entity1 = new TerritorialDivisionEntity(1L,"codigo1","descripcion1", countryEntity, 1 );
        given(service.create(any(TerritorialDivisionEntity.class))).willReturn(entity1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/business_unit/").content(BUSINESSUNIT_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        TerritorialDivisionEntity entity1 = new TerritorialDivisionEntity(1L,"codigo1","descripcion1", countryEntity, 1 );
        TerrirorialDivision terrirorialDivisionDto = new TerrirorialDivision(1L,"codigo1","descripcion1" );
        given(service.findById(1L)).willReturn(Optional.of(entity1));
        given(service.update(entity1)).willReturn(entity1);

        ResponseEntity<TerrirorialDivision> responseEntity = controller.update(terrirorialDivisionDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/catalogs/v1/business_unit/").content(BUSINESSUNIT_JSON)
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
                .delete("/catalogs/v1/business_unit/{id}",1))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}
