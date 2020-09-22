package com.neytor.timespannersoftware.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_details")
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

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_time")
    private Long startTime;

    private Long duration;

    @Column(name = "ending_date")
    private LocalDate endingDate;

    @Column(name = "ending_time")
    private Long endingTime;

    public ScheduleDetailEntity() {
        // Empty constructor
    }

    public ScheduleDetailEntity(Long id, ScheduleEntity schedule, SpotEntity spot, PersonEntity person, ContractEntity contract, int spanType, LocalDate startDate, Long startTime, Long duration, LocalDate endingDate, Long endingTime) {
        this.id = id;
        this.schedule = schedule;
        this.spot = spot;
        this.person = person;
        this.contract = contract;
        this.spanType = spanType;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.endingDate = endingDate;
        this.endingTime = endingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEntity schedule) {
        this.schedule = schedule;
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

    public int getSpanType() {
        return spanType;
    }

    public void setSpanType(int spanType) {
        this.spanType = spanType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public Long getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }
}
