package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.dto.Contract;
import com.neytor.timespannersoftware.model.mapper.ContractMapper;
import com.neytor.timespannersoftware.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    @Autowired
    public ContractServiceImpl(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contract> findAll() {
        List<ContractEntity> entities = repository.findAll();
        if(entities.isEmpty()){
            throw new EntityNotFoundException("No se encontro ninguna entidad " );
        }
        return entities.stream().map(ContractMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<Contract> findById(Long id) {
        ContractEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el id: " + id));
        return Optional.of(ContractMapper.convertToDto(entity));
    }

    @Override
    public Optional<Contract> findByReference(String reference) {
        ContractEntity entity =  repository.findByReference(reference)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el id: " + reference));
        return Optional.of(ContractMapper.convertToDto(entity));
    }

    @Override
    public List<Contract> findByIdentificationNumber(String identificationNumber) {
        List<ContractEntity> entities = repository.findByPersonIdentificationNumber(identificationNumber);
        if(entities.isEmpty()){
            throw new EntityNotFoundException("No se encontro ninguna entidad para el id: " + identificationNumber);
        }
        return entities.stream().map(ContractMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<Contract> findByIdentificationNumberContaining(String identificationNumber) {
        List<ContractEntity> entities = repository.findByPersonIdentificationNumberContaining(identificationNumber);
        if(entities.isEmpty()){
            throw new EntityNotFoundException("No se encontro ninguna entidad para el id: " + identificationNumber);
        }
        return entities.stream().map(ContractMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<Contract> findByFullNameContaining(String fullName) {
        List<ContractEntity> entities =  repository.findByPersonFullNameContaining(fullName);
        if(entities.isEmpty()){
            throw new EntityNotFoundException("No se encontro ninguna entidad para el nombre: " + fullName);
        }
        return entities.stream().map(ContractMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Contract create(Contract dto) {
        ContractEntity entity = repository.save(ContractMapper.convertToEntity(dto));
        return ContractMapper.convertToDto(entity);
    }

    @Override
    public Contract update(Contract dto) {
        if(!repository.existsById(dto.getId())){
            throw new EntityNotFoundException("No se encontro la entidad con el id: " + dto.getId());
        }
        ContractEntity entity = repository.save(ContractMapper.convertToEntity(dto));
        return ContractMapper.convertToDto(entity);
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("No se encontro la entidad con el id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
