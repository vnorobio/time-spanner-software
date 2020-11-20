package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Date {

    private Long id;

    private String code;

    private java.util.Date date;

    private Integer year;

    private Integer semester;

    private Integer month;

    private Integer weekOfYear;

    private Integer dayOfWeek;

    private Integer dayOfMonth;

    private Integer dayOfYear;

    private Boolean isHoliday;

}
