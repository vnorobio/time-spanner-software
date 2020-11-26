package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
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
