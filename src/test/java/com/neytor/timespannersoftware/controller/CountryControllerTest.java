package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.service.CountryService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import static org.mockito.ArgumentMatchers.anyInt;
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
public class CountryControllerTest {

    private EasyRandom generator = new EasyRandom();

    @InjectMocks
    CountryController controller;


    private ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Mock
    private CountryService service;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void findAllShouldReturnCountriesList() throws Exception {
        List<Country> dtos = generator.objects(Country.class, 10).collect(Collectors.toList());
        given(service.findAll()).willReturn(dtos);

        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new CountryController(service)).build();
        mockMvc.perform(get("/api/v1/configuration/countries"))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)));

    }

    @Test
    public void shouldReturnCountryWhenConsultById() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findById(anyLong())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/countries/by-id/{id}", dto.getId()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));
    }

    @Test
    public void shouldYieldStatus4xxWhenConsultById() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findById(anyLong())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/countries/by-id/{id}", dto.getId()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByNameShouldReturnCountriesList() throws Exception {
        Country dto = generator.nextObject(Country.class);
        List<Country> dtos = Arrays.asList(dto);
        given(service.findByName(anyString())).willReturn(dtos);

        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new CountryController(service)).build();
        mockMvc.perform(get("/api/v1/configuration/countries/by-name/{name}", dto.getName()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void shouldReturnCountryWhenConsultByCode() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findByNumericCode(anyInt())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/countries/by-code/{code}", dto.getNumericCode()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.numericCode", is(dto.getNumericCode())));
    }

    @Test
    public void shouldYieldStatus4xxWhenConsultByCode() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findByNumericCode(anyInt())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/countries/by-code/{code}", dto.getNumericCode()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnCountryWhenConsultByAlpha2Code() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findByAlpha2Code(anyString())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/countries/by-alpha2code/{code}", dto.getAlpha2Code()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.numericCode", is(dto.getNumericCode())));
    }

    @Test
    public void shouldYieldStatus4xxWhenConsultByAlpha2Code() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findByAlpha2Code(anyString())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/countries/by-alpha2code/{code}", dto.getAlpha2Code()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnCountryWhenConsultByAlpha3Code() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findByAlpha3Code(anyString())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/countries/by-alpha3code/{code}", dto.getAlpha3Code()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.numericCode", is(dto.getNumericCode())));
    }

    @Test
    public void shouldYieldStatus4xxWhenConsultByAlpha3Code() throws Exception {
        Country dto = generator.nextObject(Country.class);
        given(service.findByAlpha3Code(anyString())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/countries/by-alpha3code/{code}", dto.getAlpha3Code()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnSavedCountryWhenPostCountries() throws Exception {
        Country requestDto = Country.builder()
                .numericCode(999999)
                .alpha2Code("99")
                .alpha3Code("999")
                .name("Fake name")
                .build();

        Country responseDto = Country.builder()
                .id(1L)
                .numericCode(999999)
                .alpha2Code("99")
                .alpha3Code("999")
                .name("Fake name")
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.create(any(Country.class))).willReturn(responseDto);

        mockMvc.perform(post("/api/v1/configuration/countries/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnUpdatedCountryWhenPutCountries() throws Exception {
        Country requiestDto = Country.builder()
                .id(1L)
                .numericCode(999999)
                .alpha2Code("99")
                .alpha3Code("999")
                .name("Fake name")
                .build();

        Country responseDto = Country.builder()
                .id(1L)
                .numericCode(999999)
                .alpha2Code("99")
                .alpha3Code("999")
                .name("Other Fake name")
                .build();

        String json = objectMapper.writeValueAsString(requiestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        given(service.update(any(Country.class))).willReturn(responseDto);

        mockMvc.perform(put("/api/v1/configuration/countries/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldYieldStatus4xxWhenPutCountries() throws Exception {
        Country requestDto = Country.builder()
                .id(1L)
                .numericCode(999999)
                .alpha2Code("99")
                .alpha3Code("999")
                .name("Fake name")
                .build();


        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(put("/api/v1/configuration/countries/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldYieldStatusNoContentWhenDeleteCountries() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete("/api/v1/configuration/countries/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldYieldStatus4xxWhenDeleteCountries() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(delete("/api/v1/configuration/countries/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}