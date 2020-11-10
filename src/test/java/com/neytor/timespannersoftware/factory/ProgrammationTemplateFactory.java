package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;
import com.neytor.timespannersoftware.model.dto.ProgrammationTemplate;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ProgrammationTemplateFactory {

    private EasyRandom generator;

    public ProgrammationTemplateFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public ProgrammationTemplate generateProgrammationTemplateDto(){
        return generator.nextObject( ProgrammationTemplate.class );
    }

    public List<ProgrammationTemplate> generateProgrammationTemplateDtoList(int streamSize){
        return generator.objects( ProgrammationTemplate.class, streamSize ).collect( Collectors.toList());
    }

    public ProgrammationTemplateEntity generateProgrammationTemplateEntity(){
        return generator.nextObject( ProgrammationTemplateEntity.class );
    }

    public List<ProgrammationTemplateEntity> generateProgrammationTemplateEntityList(int streamSize){
        return generator.objects( ProgrammationTemplateEntity.class, streamSize ).collect( Collectors.toList());
    }
}
