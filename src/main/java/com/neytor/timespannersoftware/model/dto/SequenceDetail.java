package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class SequenceDetail {

    private Long id;

    private ProgrammationSequence programmationSequence;

    private Integer order;

    private ProgrammationTemplate programmationTemplate;

}
