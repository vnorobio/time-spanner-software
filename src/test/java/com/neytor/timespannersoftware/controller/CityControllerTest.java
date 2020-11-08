package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.service.CityService;
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
@WebMvcTest(controllers = CityController.class)
public class CityControllerTest {

    private final MockMvc mockMvc;

    private static final String BUSINESSUNIT_JSON = "{ \"id\": 1, \"code\": \"codigo1\", \"description\": \"descripcion1\"}";

    @InjectMocks
    private CityController controller;

    @MockBean
    private CityService service;

    @Autowired
    public CityControllerTest(MockMvc mockMvc, CityController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }

    @Test
    void findAll() throws Exception{
        // given
        CityEntity entity1 = new CityEntity();
        CityEntity entity2 = new CityEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findAll()).willReturn(entities);

        // when
        ResponseEntity<List<City>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/business_unit/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finById() throws Exception{
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        EstateEntity estateEntity = new EstateEntity(1L,"estate1","Desc estate", countryEntity);
        CityEntity entity1 = new CityEntity(1L,"codigo","descripcion", estateEntity, countryEntity);
        given(service.findById(2L)).willReturn(Optional.of(entity1));

        ResponseEntity<City> responseEntity = controller.finById(2L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/business_unit/id/{id}",2))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void findByDescription() throws Exception{
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        EstateEntity estateEntity = new EstateEntity(1L,"estate1","Desc estate", countryEntity);
        CityEntity entity1 = new CityEntity(1L,"codigo1","descripcion1" ,estateEntity, countryEntity);
        CityEntity entity2 = new CityEntity(2L,"codigo2","descripcion2", estateEntity, countryEntity);
        List entities = Arrays.asList(entity1,entity2);
        given(service.findByDescriptionContaining("descripcion")).willReturn(entities);

        ResponseEntity<List<City>> response = (controller.findByDescription("descripcion"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/business_unit/description/{description}","descripcion"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        EstateEntity estateEntity = new EstateEntity(1L,"estate1","Desc estate", countryEntity);
        CityEntity entity1 = new CityEntity(1L,"codigo1","descripcion1", estateEntity, countryEntity);
        given(service.create(any(CityEntity.class))).willReturn(entity1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/business_unit/").content(BUSINESSUNIT_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        CountryEntity countryEntity = new CountryEntity(1L,"Colombia",520,"co","col");
        EstateEntity estateEntity = new EstateEntity(1L,"estate1","Desc estate", countryEntity);
        CityEntity entity1 = new CityEntity(1L,"codigo1","descripcion1", estateEntity, countryEntity);
        City cityDto = new City(1L,"codigo1","descripcion1" );
        given(service.findById(1L)).willReturn(Optional.of(entity1));
        given(service.update(entity1)).willReturn(entity1);

        ResponseEntity<City> responseEntity = controller.update(cityDto);

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
