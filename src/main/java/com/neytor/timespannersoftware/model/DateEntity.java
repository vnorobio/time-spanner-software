package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
