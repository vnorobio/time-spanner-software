package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;
import com.neytor.timespannersoftware.model.dto.ProgrammationTemplate;
import org.modelmapper.ModelMapper;

public class ProgrammationTemplateMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ProgrammationTemplate convertToDto( ProgrammationTemplateEntity entity ) {
        return modelMapper.map(entity, ProgrammationTemplate.class);
    }

    public static ProgrammationTemplateEntity convertToEntity( ProgrammationTemplate dto ) {
        return modelMapper.map(dto, ProgrammationTemplateEntity.class);
    }

}
