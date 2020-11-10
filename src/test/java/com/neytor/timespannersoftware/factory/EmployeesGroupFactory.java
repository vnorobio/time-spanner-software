package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.dto.EmployeesGroup;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeesGroupFactory {

    private EasyRandom generator;

    public EmployeesGroupFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public EmployeesGroup generateEmployeesGroupDto(){
        return generator.nextObject( EmployeesGroup.class );
    }

    public List<EmployeesGroup> generateEmployeesGroupDtoList(int streamSize){
        return generator.objects( EmployeesGroup.class, streamSize ).collect( Collectors.toList());
    }

    public EmployeesGroupEntity generateEmployeesGroupEntity(){
        return generator.nextObject( EmployeesGroupEntity.class );
    }

    public List<EmployeesGroupEntity> generateEmployeesGroupEntityList(int streamSize){
        return generator.objects( EmployeesGroupEntity.class, streamSize ).collect( Collectors.toList());
    }
}
