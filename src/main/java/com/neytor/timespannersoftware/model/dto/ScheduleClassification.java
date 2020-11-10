package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.model.TimeClassificationEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScheduleClassification {

    private Long id;

    private ScheduleDetailEntity scheduleDetail;

    private TimeClassificationEntity timeClassification;

}
