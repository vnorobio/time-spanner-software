package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.model.mapper.IdentificationTypeMapper;
import com.neytor.timespannersoftware.repository.IdentificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService{

    private final IdentificationTypeRepository repository;

    @Autowired
    public IdentificationTypeServiceImpl(IdentificationTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IdentificationType> findAll() {
        List<IdentificationTypeEntity> entities = repository.findAll();
        return entities.stream()
                .map(entity -> IdentificationTypeMapper.convertToDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<IdentificationType> findById(Long id) {
        IdentificationTypeEntity entity = repository.findById(id).orElseThrow(() ->new EntityNotFoundException("There's no entity with id: " + id));
        return Optional.of(IdentificationTypeMapper.convertToDto(entity));
    }

    @Override
    public Optional<IdentificationType> findByCode(String code) {
        IdentificationTypeEntity entity = repository.findByCode(code).orElseThrow(() ->new EntityNotFoundException("There's no entity with code: " + code));
        return Optional.of(IdentificationTypeMapper.convertToDto(entity));
    }

    @Override
    public Optional<IdentificationType> findByShortenedForm(String shortenedForm) {
        IdentificationTypeEntity entity = repository.findByShortenedForm(shortenedForm).orElseThrow(() ->new EntityNotFoundException("There's no entity with shortened form: " + shortenedForm));
        return Optional.of(IdentificationTypeMapper.convertToDto(entity));
    }

    @Override
    public IdentificationType create(IdentificationType identificationType) {
        IdentificationTypeEntity entity = repository.save( IdentificationTypeMapper.convertToEntity(identificationType));
        return IdentificationTypeMapper.convertToDto(entity);
    }

    @Override
    public IdentificationType update(IdentificationType identificationType) {
        IdentificationTypeEntity entity = repository.save( IdentificationTypeMapper.convertToEntity(identificationType));
        return IdentificationTypeMapper.convertToDto(entity);
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
