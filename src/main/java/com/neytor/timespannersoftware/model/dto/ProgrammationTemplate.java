package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;

@Value
@Builder
public class ProgrammationTemplate {

    private Long id;

    private String code;

    private String description;

    private int timeOffType;

    private Long ordinaryTimeLapse; 

    private Long restTime;

}
