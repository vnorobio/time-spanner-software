package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;

@Value
@Builder
public class TimeSpan {

    private Long id;

    private String code;

    private int spanType;

    private int startDay;

    private Long startTime;

    private Long duration;

    private int endingDay;

    private Long endingTime;

    private ProgrammationTemplateEntity programmationTemplate;

}
