package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;


@Entity
@Table(name = "dates")
@Data
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_id")
    private Long id;

    private String code;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    private Integer year;

    private Integer semester;

    private Integer month;

    @Column(name = "week_of_year")
    private Integer weekOfYear;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "day_of_month")
    private Integer dayOfMonth;

    @Column(name = "day_of_year")
    private Integer dayOfYear;

    @Column(name = "is_holiday")
    private Boolean isHoliday;

}
