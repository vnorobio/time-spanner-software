package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.service.PersonService;
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
public class PersonControllerTest {

    private EasyRandom generator = new EasyRandom();

    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private PersonController controller;

    @Mock
    PersonService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnPersonListWhenFindAll() throws Exception {
        List<Person> dtoList = generator.objects(Person.class, 10).collect(Collectors.toList());

        BDDMockito.given(service.findAll()).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    void shouldReturnPersonWhenFinById() throws Exception {
        Person dto = generator.nextObject(Person.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/persons/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinById() throws Exception {
        Person dto = generator.nextObject(Person.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/configuration/persons/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void shouldReturnPersonListWhenFindByName() throws Exception {
        Person dto = generator.nextObject(Person.class);
        List<Person> dtoList = Arrays.asList(dto);
        BDDMockito.given(service.findByFullNameContaining(anyString())).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/persons/by-name/{name}", dto.getFullName()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldReturnCreatedPersonWhenPostCities() throws Exception {
        IdentificationType idType = generator.nextObject((IdentificationType.class));

        Person requestDto= Person.builder()
                .firstName("First")
                .secondName("Second")
                .firstSurname("Surname")
                .secondSurname("SecondSurname")
                .fullName("First Second Surname SecondSurname")
                .identificationType(idType)
                .identificationNumber("identificationNumber")
                .gender(1)
                .maritalStatus(0)
                .address("address")
                .email("some@email.com")
                .phoneNumber("phoneNumber")
                .build();

        Person responseDto = Person.builder()
                .id(1L)
                .firstName("First")
                .secondName("Second")
                .firstSurname("Surname")
                .secondSurname("SecondSurname")
                .fullName("First Second Surname SecondSurname")
                .identificationType(idType)
                .identificationNumber("identificationNumber")
                .gender(1)
                .maritalStatus(0)
                .address("address")
                .email("some@email.com")
                .phoneNumber("phoneNumber")
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        BDDMockito.given(service.create(any(Person.class))).willReturn(responseDto);

        mockMvc.perform(post("/api/v1/configuration/persons/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnUpdatedPersonWhenPutCities() throws Exception {
        IdentificationType idType = generator.nextObject((IdentificationType.class));

        Person requestDto= Person.builder()
                .id(1L)
                .firstName("First")
                .secondName("Second")
                .firstSurname("Surname")
                .secondSurname("SecondSurname")
                .fullName("First Second Surname SecondSurname")
                .identificationType(idType)
                .identificationNumber("identificationNumber")
                .gender(1)
                .maritalStatus(0)
                .address("address")
                .email("some@email.com")
                .phoneNumber("phoneNumber")
                .build();

        Person responseDto = Person.builder()
                .id(1L)
                .firstName("First")
                .secondName("Second")
                .firstSurname("Surname")
                .secondSurname("SecondSurname")
                .fullName("First Second Surname SecondSurname")
                .identificationType(idType)
                .identificationNumber("identificationNumber")
                .gender(1)
                .maritalStatus(0)
                .address("OtherAddress")
                .email("some@email.com")
                .phoneNumber("phoneNumber")
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.TRUE);
        BDDMockito.given(service.update(any(Person.class))).willReturn(responseDto);

        mockMvc.perform(put("/api/v1/configuration/persons/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isAccepted());

    }

    @Test
    void shouldYieldStatus4xxWhenPutCities() throws Exception {
        IdentificationType idType = generator.nextObject((IdentificationType.class));

        Person requestDto= Person.builder()
                .id(1L)
                .firstName("First")
                .secondName("Second")
                .firstSurname("Surname")
                .secondSurname("SecondSurname")
                .fullName("First Second Surname SecondSurname")
                .identificationType(idType)
                .identificationNumber("identificationNumber")
                .gender(1)
                .maritalStatus(0)
                .address("OtherAddress")
                .email("some@email.com")
                .phoneNumber("phoneNumber")
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(put("/api/v1/configuration/persons/")
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

        mockMvc.perform(delete("/api/v1/configuration/persons/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldYieldStatus4xxWhenDeleteCities() throws Exception {
        Long id = 1l;
        given(service.existsById(anyLong())).willReturn(Boolean.FALSE);

        mockMvc.perform(delete("/api/v1/configuration/persons/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}