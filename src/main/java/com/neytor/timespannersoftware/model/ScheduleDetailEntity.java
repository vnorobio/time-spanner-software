package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_details")
@Data
public class ScheduleDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_detail_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", insertable = false, updatable = false)
    private ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "spot_id", referencedColumnName = "spot_id", insertable = false, updatable = false)
    private SpotEntity spot;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
    private ContractEntity contract;

    @Column(name = "span_type")
    private int spanType;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "start_time")
    private Long startTime;

    private Long duration;

    @Column(name = "ending_date", columnDefinition = "DATE")
    private LocalDate endingDate;

    @Column(name = "ending_time")
    private Long endingTime;

}
