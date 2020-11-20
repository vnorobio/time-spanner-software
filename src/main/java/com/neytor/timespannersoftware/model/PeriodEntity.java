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

    private Integer periodicity;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    private Integer duration;

    @Column(name = "ending_date", columnDefinition = "DATE")
    private LocalDate endingDate;

}
