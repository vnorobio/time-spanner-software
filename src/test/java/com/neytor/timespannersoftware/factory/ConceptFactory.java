package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ConceptEntity;
import com.neytor.timespannersoftware.model.dto.Concept;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ConceptFactory {

    private EasyRandom generator;

    public ConceptFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Concept generateConceptDto(){
        return generator.nextObject( Concept.class );
    }

    public List<Concept> generateConceptDtoList(int streamSize){
        return generator.objects( Concept.class, streamSize ).collect( Collectors.toList());
    }

    public ConceptEntity generateConceptEntity(){
        return generator.nextObject( ConceptEntity.class );
    }

    public List<ConceptEntity> generateConceptEntityList(int streamSize){
        return generator.objects( ConceptEntity.class, streamSize ).collect( Collectors.toList());
    }
}
