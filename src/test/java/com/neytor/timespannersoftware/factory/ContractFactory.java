package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.dto.Contract;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ContractFactory {

    private EasyRandom generator;

    public ContractFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Contract generateContractDto(){
        return generator.nextObject( Contract.class );
    }

    public List<Contract> generateContractDtoList(int streamSize){
        return generator.objects( Contract.class, streamSize ).collect( Collectors.toList());
    }

    public ContractEntity generateContractEntity(){
        return generator.nextObject( ContractEntity.class );
    }

    public List<ContractEntity> generateContractEntityList(int streamSize){
        return generator.objects( ContractEntity.class, streamSize ).collect( Collectors.toList());
    }
}
