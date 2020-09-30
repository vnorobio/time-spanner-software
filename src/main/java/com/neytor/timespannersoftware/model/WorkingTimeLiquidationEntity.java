package com.neytor.timespannersoftware.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "working_time_liquidations")
public class WorkingTimeLiquidationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_time_liquidation_id")
    private Long id;

    @Column(name = "liquidation_date")
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

    public WorkingTimeLiquidationEntity() {
        // Empty constructor
    }

    public WorkingTimeLiquidationEntity(Long id, LocalDate date, ScheduleEntity schedule, ScheduleDetailEntity detail, SpotEntity spot, PersonEntity person, ContractEntity contract, ConceptEntity concept, BigDecimal appliedRatio, BigDecimal baseSalary, Long amountOfTime, BigDecimal liquidationValue) {
        this.id = id;
        this.date = date;
        this.schedule = schedule;
        this.detail = detail;
        this.spot = spot;
        this.person = person;
        this.contract = contract;
        this.concept = concept;
        this.appliedRatio = appliedRatio;
        this.baseSalary = baseSalary;
        this.amountOfTime = amountOfTime;
        this.liquidationValue = liquidationValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEntity schedule) {
        this.schedule = schedule;
    }

    public ScheduleDetailEntity getDetail() {
        return detail;
    }

    public void setDetail(ScheduleDetailEntity detail) {
        this.detail = detail;
    }

    public SpotEntity getSpot() {
        return spot;
    }

    public void setSpot(SpotEntity spot) {
        this.spot = spot;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }

    public ConceptEntity getConcept() {
        return concept;
    }

    public void setConcept(ConceptEntity concept) {
        this.concept = concept;
    }

    public BigDecimal getAppliedRatio() {
        return appliedRatio;
    }

    public void setAppliedRatio(BigDecimal appliedRatio) {
        this.appliedRatio = appliedRatio;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Long getAmountOfTime() {
        return amountOfTime;
    }

    public void setAmountOfTime(Long amountOfTime) {
        this.amountOfTime = amountOfTime;
    }

    public BigDecimal getLiquidationValue() {
        return liquidationValue;
    }

    public void setLiquidationValue(BigDecimal liquidationValue) {
        this.liquidationValue = liquidationValue;
    }
}
