package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.service.PersonService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    private final EasyRandom generator = new EasyRandom(  );

    @MockBean
    private PersonService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldListAllPersons() throws Exception {
        List<Person> dtos = generator.objects(Person.class,10).collect(Collectors.toList());

        when(service.findAll()).thenReturn(dtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/configuration/persons/"))
                .andExpect(MockMvcResultMatchers.status().isOk());


/*

                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$size()", Matchers.is(10)));
*/
    }
/*
    @Test
    void finById() {
        fail("Not implemented yet");
    }

    @Test
    void findByLogin() {
        fail("Not implemented yet");
    }

    @Test
    void create() {
        fail("Not implemented yet");
    }

    @Test
    void update() {
        fail("Not implemented yet");
    }

    @Test
    void delete() {
        fail("Not implemented yet");
    }
    */
}