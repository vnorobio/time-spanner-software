package com.neytor.timespannersoftware.controller;

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

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CountryControllerTest {

    private EasyRandom generator = new EasyRandom();

    @InjectMocks
    CountryController controller;

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


}