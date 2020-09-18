package com.neytor.timespannersoftware.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "periods")
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

    public PeriodEntity() {
        // Empty constructor
    }

    public PeriodEntity(Long id, String code, Long previousPeriod, Integer year, int periodicity, LocalDate startDate, int duration, LocalDate endingDate, int projectedInterval, LocalDate projectionStartDate) {
        this.id = id;
        this.code = code;
        this.previousPeriod = previousPeriod;
        this.year = year;
        this.periodicity = periodicity;
        this.startDate = startDate;
        this.duration = duration;
        this.endingDate = endingDate;
        this.projectedInterval = projectedInterval;
        this.projectionStartDate = projectionStartDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPreviousPeriod() {
        return previousPeriod;
    }

    public void setPreviousPeriod(Long previousPeriod) {
        this.previousPeriod = previousPeriod;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public int getProjected_interval() {
        return projectedInterval;
    }

    public void setProjected_interval(int projectedInterval) {
        this.projectedInterval = projectedInterval;
    }

    public LocalDate getProjectionStartDate() {
        return projectionStartDate;
    }

    public void setProjectionStartDate(LocalDate projectionStartDate) {
        this.projectionStartDate = projectionStartDate;
    }
}
