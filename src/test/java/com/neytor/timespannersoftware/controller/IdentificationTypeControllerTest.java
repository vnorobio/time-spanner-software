package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.service.IdentificationTypeService;
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
public class IdentificationTypeControllerTest {

    private EasyRandom generator = new EasyRandom();

    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private IdentificationTypeController controller;

    @Mock
    IdentificationTypeService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnIdentificationTypeListWhenFindAll() throws Exception {
        List<IdentificationType> dtoList = generator.objects(IdentificationType.class, 10).collect(Collectors.toList());

        BDDMockito.given(service.findAll()).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/identification-types"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    void shouldReturnIdentificationTypeWhenFinById() throws Exception {
        IdentificationType dto = generator.nextObject(IdentificationType.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/identification-types/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinById() throws Exception {
        IdentificationType dto = generator.nextObject(IdentificationType.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/identification-types/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void shouldReturnIdentificationTypeWhenFinByCode() throws Exception {
        IdentificationType dto = generator.nextObject(IdentificationType.class);
        BDDMockito.given(service.findByCode(anyString())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/identification-types/by-code/{code}", dto.getCode()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinByCode() throws Exception {
        IdentificationType dto = generator.nextObject(IdentificationType.class);
        BDDMockito.given(service.findByCode(anyString())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/identification-types/by-code/{code}", dto.getCode()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void shouldReturnIdentificationTypeWhenFinByShortenedForm() throws Exception {
        IdentificationType dto = generator.nextObject(IdentificationType.class);
        BDDMockito.given(service.findByShortenedForm(anyString())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/identification-types/by-short/{shortenedForm}", dto.getShortenedForm()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinByShortenedForm() throws Exception {
        IdentificationType dto = generator.nextObject(IdentificationType.class);
        BDDMockito.given(service.findByShortenedForm(anyString())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/identification-types/by-short/{shortenedForm}", dto.getShortenedForm()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

}