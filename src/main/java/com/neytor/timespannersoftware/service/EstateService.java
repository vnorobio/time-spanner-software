package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;

import java.util.List;
import java.util.Optional;

public interface EstateService {
    List<Estate> findAll();

    List< Estate > findByCountry( Country dto);

    Optional<Estate> findById(Long id);

    Optional<Estate> findByCode(String code);

    List<Estate> findByCodeContaining(String code);

    List<Estate> findByDescriptionContaining(String description);

    Estate create(Estate dto);

    Estate update(Estate dto);

    void delete(Long id);

    Boolean existsById(Long id);
}
