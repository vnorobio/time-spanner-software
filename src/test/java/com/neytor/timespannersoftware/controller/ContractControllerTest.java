package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Contract;
import com.neytor.timespannersoftware.model.dto.Contract;
import com.neytor.timespannersoftware.model.dto.EmployeesGroup;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.service.ContractService;
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

import java.math.BigDecimal;
import java.time.LocalDate;
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
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ContractControllerTest {

    private EasyRandom generator = new EasyRandom();

    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private ContractController controller;

    @Mock
    ContractService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnContractListWhenFindAll() throws Exception {
        List<Contract> dtoList = generator.objects(Contract.class, 10).collect(Collectors.toList());

        BDDMockito.given(service.findAll()).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/contracts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    void shouldReturn4xxErrorWhenFindAll() throws Exception {
        doThrow(new EntityNotFoundException("Exepcion de prueba")).when(service).findAll();

           mockMvc.perform(get("/api/v1/configuration/contracts"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void shouldReturnContractWhenFinById() throws Exception {
        Contract dto = generator.nextObject(Contract.class);
        BDDMockito.given(service.findById(anyLong())).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/configuration/contracts/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(dto.getId())));

    }

    @Test
    void shouldYieldStatus4xxWhenFinById() throws Exception {
        Contract dto = generator.nextObject(Contract.class);
        doThrow(new EntityNotFoundException("Exepcion de prueba")).when(service).findById(anyLong());

        mockMvc.perform(get("/api/v1/configuration/contracts/by-id/{id}", dto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void shouldReturnContractListWhenFindByIdentification() throws Exception {
        Contract dto = generator.nextObject(Contract.class);
        List<Contract> dtoList = Arrays.asList(dto);
        BDDMockito.given(service.findByIdentificationNumber(anyString())).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/contracts/by-identification/{identification}", dto.getPerson().getIdentificationNumber()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldYieldStatus4xxWhenFindByIdentification() throws Exception {
        Contract dto = generator.nextObject(Contract.class);
        doThrow(new EntityNotFoundException("Exepcion de prueba")).when(service).findByIdentificationNumber(anyString());
        mockMvc.perform(get("/api/v1/configuration/contracts/by-identification/{identification}", dto.getPerson().getIdentificationNumber()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void shouldReturnContractListWhenFindByName() throws Exception {
        Contract dto = generator.nextObject(Contract.class);
        List<Contract> dtoList = Arrays.asList(dto);
        BDDMockito.given(service.findByFullNameContaining(anyString())).willReturn(dtoList);

        mockMvc.perform(get("/api/v1/configuration/contracts/by-name/{name}", dto.getPerson().getFullName()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldYieldStatus4xxWhenFindByName() throws Exception {
        Contract dto = generator.nextObject(Contract.class);
        doThrow(new EntityNotFoundException("Exepcion de prueba")).when(service).findByFullNameContaining(anyString());
        mockMvc.perform(get("/api/v1/configuration/contracts/by-name/{name}", dto.getPerson().getFullName()))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void shouldReturnCreatedContractWhenPostContract() throws Exception {
        Person person = generator.nextObject((Person.class));
        City city = generator.nextObject((City.class));
        EmployeesGroup employeesGroup = generator.nextObject(EmployeesGroup.class);
        Contract requestDto= Contract.builder()
                .reference("Reference")
                .person(person)
                .contractType(1)
                .startDate(LocalDate.now())
                .salary(new BigDecimal(2000000))
                .payrollPeriodicity(1)
                .employeesGroup(employeesGroup)
                .city(city)
                .build();

        Contract responseDto = Contract.builder()
                .id(1L)
                .reference("Reference")
                .person(person)
                .contractType(1)
                .startDate(LocalDate.now())
                .salary(new BigDecimal(2000000))
                .payrollPeriodicity(1)
                .employeesGroup(employeesGroup)
                .city(city)
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        BDDMockito.given(service.create(any(Contract.class))).willReturn(responseDto);

        mockMvc.perform(post("/api/v1/configuration/contracts/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnUpdatedContractWhenPutContract() throws Exception {
        Person person = generator.nextObject((Person.class));
        City city = generator.nextObject((City.class));
        EmployeesGroup employeesGroup = generator.nextObject(EmployeesGroup.class);

        Contract requestDto= Contract.builder()
                .id(1L)
                .reference("Reference")
                .person(person)
                .contractType(1)
                .startDate(LocalDate.now())
                .salary(new BigDecimal(3000000))
                .payrollPeriodicity(1)
                .employeesGroup(employeesGroup)
                .city(city)
                .build();

        Contract responseDto = Contract.builder()
                .id(1L)
                .reference("Reference")
                .person(person)
                .contractType(1)
                .startDate(LocalDate.now())
                .salary(new BigDecimal(3000000))
                .payrollPeriodicity(1)
                .employeesGroup(employeesGroup)
                .city(city)
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        BDDMockito.given(service.update(any(Contract.class))).willReturn(responseDto);

        mockMvc.perform(put("/api/v1/configuration/contracts/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().isAccepted());

    }

    @Test
    void shouldYieldStatus4xxWhenPutContract() throws Exception {
        Person person = generator.nextObject((Person.class));
        City city = generator.nextObject((City.class));
        EmployeesGroup employeesGroup = generator.nextObject(EmployeesGroup.class);

        Contract requestDto= Contract.builder()
                .id(1L)
                .reference("Reference")
                .person(person)
                .contractType(1)
                .startDate(LocalDate.now())
                .salary(new BigDecimal(2000000))
                .payrollPeriodicity(1)
                .employeesGroup(employeesGroup)
                .city(city)
                .build();

        String json = objectMapper.writeValueAsString(requestDto);
        given(service.update(any(Contract.class)))
                .willThrow(new EntityNotFoundException("Exepcion de prueba"));

        mockMvc.perform(put("/api/v1/configuration/contracts/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void shouldYieldStatusNoContentWhenDeleteCities() throws Exception {
        Long id = 1l;
        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete("/api/v1/configuration/contracts/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldYieldStatus4xxWhenDeleteCities() throws Exception {
        Long id = 1l;
        doThrow(new EntityNotFoundException("Exepcion de prueba")).when(service).delete(anyLong());

        mockMvc.perform(delete("/api/v1/configuration/contracts/by-id/{id}", id) )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}