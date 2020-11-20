package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SequenceDetail {

    private Long id;

    private ProgrammationSequence programmationSequence;

    private Integer order;

    private ProgrammationTemplate programmationTemplate;

}
