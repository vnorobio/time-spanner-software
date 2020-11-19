package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "working_time_liquidations")
@Data
public class WorkingTimeLiquidationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_time_liquidation_id")
    private Long id;

    @Column(name = "liquidation_date", columnDefinition = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", insertable = false, updatable = false)
    private ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "schedule_detail_id", referencedColumnName = "schedule_detail_id", insertable = false, updatable = false)
    private ScheduleDetailEntity detail;

    @ManyToOne
    @JoinColumn(name = "spot_id", referencedColumnName = "spot_id", insertable = false, updatable = false)
    private SpotEntity spot;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
    private ContractEntity contract;

    @ManyToOne
    @JoinColumn(name = "concept_id", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity concept;

    @JoinColumn(name = "applied_ratio", referencedColumnName = "applied_ratio", insertable = false, updatable = false)
    private BigDecimal appliedRatio;

    @JoinColumn(name = "base_salary", referencedColumnName = "base_salary", insertable = false, updatable = false)
    private BigDecimal baseSalary;

    @JoinColumn(name = "amount_of_time", referencedColumnName = "amount_of_time", insertable = false, updatable = false)
    private Long amountOfTime;

    @JoinColumn(name = "liquidation_value", referencedColumnName = "liquidation_value", insertable = false, updatable = false)
    private BigDecimal liquidationValue;

}
