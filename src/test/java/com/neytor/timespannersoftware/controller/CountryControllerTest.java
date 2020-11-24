package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.service.CountryService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTest {

    private EasyRandom generator = new EasyRandom(  );

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService service;

    @Test
    public void findAllShouldReturnCountriesList() throws Exception {
        List<Country> dtos = generator.objects(Country.class,10).collect(Collectors.toList());
        doReturn(dtos).when(service).findAll();

        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new CountryController(service)).build();
        mockMvc.perform(get("/api/v1/configuration/countries"))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }


}