package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.service.EstateService;
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
public class EstateControllerTest {

    private EasyRandom generator = new EasyRandom();

    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private EstateController controller;

    @Mock
    EstateService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnEstateListWhenFindAll() throws Exception {
        List<Estate> dtoList = generator.objects(Estate.class, 10).collect(Collectors.toList());

        BDDMockito.given(service.findAll()).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/estates"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    void shouldReturnEstateWhenFinById() throws Exception {
        Estate dto = generator.nextObject(Estate.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/estates/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinById() throws Exception {
        Estate dto = generator.nextObject(Estate.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/estates/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void shouldReturnEstateListWhenFindByDescription() throws Exception {
        Estate dto = generator.nextObject(Estate.class);
        List<Estate> dtoList = Arrays.asList(dto);
        BDDMockito.given(service.findByDescriptionContaining(anyString())).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/estates/by-description/{description}", dto.getDescription()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldReturnCreatedEstateWhenPostEstates() throws Exception {
        Estate estate = generator.nextObject((Estate.class));

        Estate requestDto= Estate.builder()
                .code("Code")
                .description("Description")
                .country(estate.getCountry())
                .build();

        Estate responseDto = Estate.builder()
                .id(1L)
                .code("Code")
                .description("Description")
                .country(estate.getCountry())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        BDDMockito.given(service.create(any(Estate.class))).willReturn(responseDto);

        mockMvc.perform(post("/api/v1/configuration/estates/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnUpdatedEstateWhenPutEstates() throws Exception {
        Estate estate = generator.nextObject((Estate.class));

        Estate requestDto= Estate.builder()
                .id(1L)
                .code("Code")
                .description("Description")
                .country(estate.getCountry())
                .build();

        Estate responseDto = Estate.builder()
                .id(1L)
                .code("Code")
                .description("New description")
                .country(estate.getCountry())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        BDDMockito.given(service.update(any(Estate.class))).willReturn(responseDto);

        mockMvc.perform(put("/api/v1/configuration/estates/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isAccepted());

    }

    @Test
    void shouldYieldStatus4xxWhenPutEstates() throws Exception {
        Estate estate = generator.nextObject((Estate.class));

        Estate requestDto= Estate.builder()
                .id(1L)
                .code("Code")
                .description("Description")
                .country(estate.getCountry())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(put("/api/v1/configuration/estates/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void shouldYieldStatusNoContentWhenDeleteEstates() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete("/api/v1/configuration/estates/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldYieldStatus4xxWhenDeleteEstates() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(delete("/api/v1/configuration/estates/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}