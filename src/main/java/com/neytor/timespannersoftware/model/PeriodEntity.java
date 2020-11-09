package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "periods")
@Data
public class PeriodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "period_id")
    private Long id;

    private String code;

    @Column(name = "previous_period")
    private Long previousPeriod;

    private Integer year;

    private int periodicity;

    @Column(name = "start_date")
    private LocalDate startDate;

    private int duration;

    @Column(name = "ending_date")
    private LocalDate endingDate;

    @Column(name = "projected_interval")
    private int projectedInterval;

    @Column(name = "projection_start_date")
    private LocalDate projectionStartDate;

}
