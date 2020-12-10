package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.dto.EmployeesGroup;
import com.neytor.timespannersoftware.model.mapper.EmployeesGroupMapper;
import com.neytor.timespannersoftware.repository.EmployeesGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesGroupServiceImpl implements EmployeesGroupService{

    private final EmployeesGroupRepository repository;

    @Autowired
    public EmployeesGroupServiceImpl(EmployeesGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeesGroup> findAll() {
        List<EmployeesGroupEntity> entities = repository.findAll();
        return entities.stream( ).map( EmployeesGroupMapper::convertToDto).collect( Collectors.toList( ) );
    }

    @Override
    public Optional<EmployeesGroup> findById(Long id) {
        EmployeesGroupEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el id: " + id));
        return Optional.of( EmployeesGroupMapper.convertToDto( entity ) );
    }

    @Override
    public Optional<EmployeesGroup> findByCode(String code) {
        EmployeesGroupEntity entity =  repository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el codigo: " + code));
        return Optional.of( EmployeesGroupMapper.convertToDto( entity ) );
    }

    @Override
    public List<EmployeesGroup> findByCodeContaining(String code) {
        List<EmployeesGroupEntity> entities = repository.findByCodeContaining(code);
        return entities.stream( ).map( EmployeesGroupMapper::convertToDto).collect( Collectors.toList( ) );
    }

    @Override
    public List<EmployeesGroup> findByDescriptionContaining(String description) {
        List<EmployeesGroupEntity> entities = repository.findByDescriptionContaining(description);
        return entities.stream( ).map( EmployeesGroupMapper::convertToDto).collect( Collectors.toList( ) );
    }

    @Override
    public EmployeesGroup create(EmployeesGroup dto) {
        EmployeesGroupEntity entity =  repository.save(EmployeesGroupMapper.convertToEntity(dto));
        return EmployeesGroupMapper.convertToDto(entity);
    }

    @Override
    public EmployeesGroup update(EmployeesGroup dto) {
        EmployeesGroupEntity entity =  repository.save(EmployeesGroupMapper.convertToEntity(dto));
        return EmployeesGroupMapper.convertToDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
