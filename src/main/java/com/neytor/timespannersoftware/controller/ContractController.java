package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Contract;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.BusinessUnitEntity;
import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.CostsCenterEntity;
import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.OperatingCenterEntity;
import com.neytor.timespannersoftware.model.ProjectEntity;
import com.neytor.timespannersoftware.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@Api("contracts")
public class ContractController {

    public static final String NOT_CONTRACT_FOUND_WITH_ID = "Not contract found with id: ";
    public static final String NOT_CONTRACT_FOUND_WITH_REFERENCE = "Not contract found with reference: ";
    private final ContractService service;
    private ModelMapper modelMapper;

    @Autowired
    public ContractController(ContractService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/contract/all", produces = "application/json")
    @ApiOperation(value = "List all contracts", response = ContractEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Contract>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/contract/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a contract by id", response = ContractEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the contract"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Contract> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_CONTRACT_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/contract/reference/{reference}", produces = "application/json")
    @ApiOperation(value = "Find a contract by reference", response = ContractEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the contract"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Contract> findByReference(@PathVariable(value = "reference") String reference) {
        return ResponseEntity.ok().body(convertToDto(service.findByReference(reference).orElseThrow(() -> new EntityNotFoundException(NOT_CONTRACT_FOUND_WITH_REFERENCE + reference))));
    }

    @GetMapping(path = "/v1/contract/identification/{identification}", produces = "application/json")
    @ApiOperation(value = "Find a contract by description", response = ContractEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the contract"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Contract>>  findByIdentificationNumber(@PathVariable(value = "identification") String identification) {
        return ResponseEntity.ok().body(service.findByIdentificationNumberContaining(identification).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/contract/full_name/{fullName}", produces = "application/json")
    @ApiOperation(value = "Find a contract by description", response = ContractEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the contract"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Contract>>  findByFullName(@PathVariable(value = "fullName") String fullName) {
        return ResponseEntity.ok().body(service.findByFullNameContaining(fullName).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/contract", produces = "application/json")
    @ApiOperation(value = "Create contract", response = ContractEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "contract successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create contracts"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<Contract> create(@RequestBody Contract dto) {
        ContractEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/contract", produces = "application/json")
    @ApiOperation(value = "Update contract", response = ContractEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "contract successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update contracts"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Contract> update(@RequestBody Contract updateDto) {
        ContractEntity entity = service.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_CONTRACT_FOUND_WITH_ID + updateDto.getId()));
        entity.setContractType(updateDto.getContractType());
        entity.setStartDate(Date.valueOf(updateDto.getStartDate()));
        entity.setEndingDate(Date.valueOf(updateDto.getEndingDate()));
        entity.setSalary(updateDto.getSalary());
        entity.setPayrollPeriodicity(updateDto.getPayrollPeriodicity());
        entity.setEmployeesGroup(modelMapper.map(updateDto.getEmployeesGroup(), EmployeesGroupEntity.class));
        entity.setOperatingCenter(modelMapper.map(updateDto.getOperatingCenter(), OperatingCenterEntity.class));
        entity.setCostsCenter(modelMapper.map(updateDto.getCostsCenter(), CostsCenterEntity.class));
        entity.setBusinessUnit(modelMapper.map(updateDto.getBusinessUnit(), BusinessUnitEntity.class));
        entity.setProject(modelMapper.map(updateDto.getProject(), ProjectEntity.class));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/contract/{id}", produces = "application/json")
    @ApiOperation(value = "Delete contract by id", response = Contract.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "contract successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete contracts"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Contract> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_CONTRACT_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private Contract convertToDto(ContractEntity entity) {
        return modelMapper.map(entity, Contract.class);
    }

    private ContractEntity convertToEntity(Contract dto) {
        return modelMapper.map(dto, ContractEntity.class);
    }
}
