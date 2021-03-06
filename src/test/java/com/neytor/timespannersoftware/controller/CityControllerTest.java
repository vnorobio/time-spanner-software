package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.service.CityService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CityControllerTest {

    private EasyRandom generator = new EasyRandom();

    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private CityController controller;

    @Mock
    CityService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnCityListWhenFindAll() throws Exception {
        List<City> dtoList = generator.objects(City.class, 10).collect(Collectors.toList());

        BDDMockito.given(service.findAll()).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/cities"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    void shouldReturnCityWhenFinById() throws Exception {
        City dto = generator.nextObject(City.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/cities/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinById() throws Exception {
        City dto = generator.nextObject(City.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/cities/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void shouldReturnCityListWhenFindByDescription() throws Exception {
        City dto = generator.nextObject(City.class);
        List<City> dtoList = Arrays.asList(dto);
        BDDMockito.given(service.findByDescriptionContaining(anyString())).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/cities/by-description/{description}", dto.getDescription()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldReturnCreatedCityWhenPostCities() throws Exception {
        Estate estate = generator.nextObject((Estate.class));

        City requestDto= City.builder()
                .code("Code")
                .description("Description")
                .estate(estate)
                .country(estate.getCountry())
                .build();

        City responseDto = City.builder()
                .id(1L)
                .code("Code")
                .description("Description")
                .estate(estate)
                .country(estate.getCountry())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        BDDMockito.given(service.create(any(City.class))).willReturn(responseDto);

        mockMvc.perform(post("/api/v1/configuration/cities/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnUpdatedCityWhenPutCities() throws Exception {
        Estate estate = generator.nextObject((Estate.class));

        City requestDto= City.builder()
                .id(1L)
                .code("Code")
                .description("Description")
                .estate(estate)
                .country(estate.getCountry())
                .build();

        City responseDto = City.builder()
                .id(1L)
                .code("Code")
                .description("New description")
                .estate(estate)
                .country(estate.getCountry())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        BDDMockito.given(service.update(any(City.class))).willReturn(responseDto);

        mockMvc.perform(put("/api/v1/configuration/cities/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isAccepted());

    }

    @Test
    void shouldYieldStatus4xxWhenPutCities() throws Exception {
        Estate estate = generator.nextObject((Estate.class));

        City requestDto= City.builder()
                .id(1L)
                .code("Code")
                .description("Description")
                .estate(estate)
                .country(estate.getCountry())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(put("/api/v1/configuration/cities/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void shouldYieldStatusNoContentWhenDeleteCities() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete("/api/v1/configuration/cities/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldYieldStatus4xxWhenDeleteCities() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(delete("/api/v1/configuration/cities/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}