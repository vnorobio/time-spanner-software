package com.neytor.timespannersoftware.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neytor.timespannersoftware.dto.BusinessUnit;
import com.neytor.timespannersoftware.dto.Contract;
import com.neytor.timespannersoftware.dto.Contract;
import com.neytor.timespannersoftware.dto.CostsCenter;
import com.neytor.timespannersoftware.dto.EmployeesGroup;
import com.neytor.timespannersoftware.dto.IdentificationType;
import com.neytor.timespannersoftware.dto.OperatingCenter;
import com.neytor.timespannersoftware.dto.Person;
import com.neytor.timespannersoftware.dto.Project;
import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.service.ContractService;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ContractController.class)
public class ContractControllerTest {

    private final MockMvc mockMvc;

    private final String CONTRACT_JSON; //= "{ \"id\": 1, \"reference\": \"reference1\",\"person\" PERSON_JSON, \"contractType\": 1, \"startDate\": \"2020-01-01\", \"endingDate\": \"2020-01-31\", \"salary\": 2000000, \"payrollPeriodicity\": 1         }";

    private EmployeesGroup employeesGroup;

    private OperatingCenter operatingCenter;

    private CostsCenter costsCenter;

    private BusinessUnit businessUnit;

    private Project project;

    @InjectMocks
    private ContractController controller;

    @MockBean
    private ContractService service;

    @Autowired
    public ContractControllerTest(MockMvc mockMvc, ContractController controller) throws JsonProcessingException {
        this.mockMvc = mockMvc;
        this.controller = controller;
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person(1l,"Jhon",null,"Doe",null,"Doe Jhon",new IdentificationType(),"1234567890",1,0,"Some address","jhon@somedomain.com","444444");
        EmployeesGroup employeesGroup = new EmployeesGroup(1l,"EG Code","EG Description");
        BusinessUnit businessUnit = new BusinessUnit(1L,"BU Code","BU description");
        CostsCenter costsCenter = new CostsCenter(1L,"CC Code","CC description");
        OperatingCenter operatingCenter = new OperatingCenter(1L,"OC Code","OC description");
        Project project = new Project(1L,"P Code","P description");
        Contract contract = new Contract(1l,"DoeJhon-1",person,1, LocalDate.of(2020,1,1),LocalDate.of(2020,1,31),new BigDecimal(2000000),1,employeesGroup,operatingCenter,costsCenter,businessUnit,project);
        CONTRACT_JSON = mapper.writeValueAsString(contract);
    }

    @Test
    void findAll() throws Exception{
        // given
        ContractEntity entity1 = new ContractEntity();
        ContractEntity entity2 = new ContractEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findAll()).willReturn(entities);

        // when
        ResponseEntity<List<Contract>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/contract/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finById() throws Exception{
        ContractEntity entity1 = new ContractEntity();
        entity1.setId(1L);
        given(service.findById(1L)).willReturn(Optional.of(entity1));

        ResponseEntity<Contract> responseEntity = controller.finById(1L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/contract/id/{id}",2))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void findByReference() throws Exception{
        ContractEntity entity1 = new ContractEntity();
        entity1.setId(1L);
        entity1.setReference("reference");
        given(service.findByReference("reference")).willReturn(Optional.of(entity1));

        ResponseEntity<Contract> response = (controller.findByReference("reference"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/contract/reference/{reference}","reference"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void findByIdentificationNumber() throws Exception{
        // given
        ContractEntity entity1 = new ContractEntity();
        ContractEntity entity2 = new ContractEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findByIdentificationNumber("1234")).willReturn(entities);

        // when
        ResponseEntity<List<Contract>> responseEntity = controller.findByIdentificationNumber("1234");

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/contract/identification/{identification}"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void findByFullName() throws Exception{
        // given
        ContractEntity entity1 = new ContractEntity();
        ContractEntity entity2 = new ContractEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findByFullNameContaining("Doe")).willReturn(entities);

        // when
        ResponseEntity<List<Contract>> responseEntity = controller.findByFullName("Doe");

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/contract/full_name/{fullName}"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
        ContractEntity entity1 = new ContractEntity();
        given(service.create(any(ContractEntity.class))).willReturn(entity1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/contract/").content(CONTRACT_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }


    @Test
    void update() throws Exception {
        ContractEntity entity1 = new ContractEntity( );
        Contract contractDto = new Contract();
        given(service.findById(1L)).willReturn(Optional.of(entity1));
        given(service.update(entity1)).willReturn(entity1);

        ResponseEntity<Contract> responseEntity = controller.update(contractDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/catalogs/v1/contract/").content(CONTRACT_JSON)
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
                .delete("/catalogs/v1/contract/{id}",1))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}
