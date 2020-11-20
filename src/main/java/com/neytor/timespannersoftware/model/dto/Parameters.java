package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Parameters {
    
    private Long id;

    private Long maximumWorkTimePerDay;

    private Long maximumWorkTimePerWeek;

    private Long manimumRestTimePerWeek;

    private Concept  workingHoursConcept;

    private Concept  overtimeSurchargeConcept;

    private Concept  nightSurchargeConcept;

    private Concept  holidaySurchargeConcept;

    private Concept  sundaySurchargeConcept;

    private Concept  compensationSurchargeConcept;

}
