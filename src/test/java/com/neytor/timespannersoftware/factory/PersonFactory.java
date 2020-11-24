package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.dto.Person;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class PersonFactory {

    private EasyRandom generator = new EasyRandom(  );

    public PersonFactory( ) {
    }

    public Person generatePersonDto(){
        return generator.nextObject( Person.class );
    }

    public List<Person> generatePersonDtoList(int streamSize){
        return generator.objects( Person.class, streamSize ).collect( Collectors.toList());
    }

    public PersonEntity generatePersonEntity(){
        return generator.nextObject( PersonEntity.class );
    }

    public List<PersonEntity> generatePersonEntityList(int streamSize){
        return generator.objects( PersonEntity.class, streamSize ).collect( Collectors.toList());
    }
}
