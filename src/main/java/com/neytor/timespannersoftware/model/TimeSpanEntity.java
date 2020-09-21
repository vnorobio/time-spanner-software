package com.neytor.timespannersoftware.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "time_spans")
public class TimeSpanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_span_id")
    private Long id;

    private String code;

    @Column(name = "span_type")
    private int spanType;

    @Column(name = "start_day")
    private int startDay;

    @Column(name = "start_time")
    private Long startTime;

    private Long duration;

    @Column(name = "ending_day")
    private int endingDay;

    @Column(name = "ending_time")
    private Long endingTime;

    @ManyToOne
    @JoinColumn(name = "programmation_template_id", referencedColumnName = "programmation_template_id", insertable = false, updatable = false)
    private ProgrammationTemplateEntity programmationTemplate;

    public TimeSpanEntity() {
        // Empty constructor
    }

    public TimeSpanEntity(Long id, String code, int spanType, int startDay, Long startTime, Long duration, int endingDay, Long endingTime, ProgrammationTemplateEntity programmationTemplate) {
        this.id = id;
        this.code = code;
        this.spanType = spanType;
        this.startDay = startDay;
        this.startTime = startTime;
        this.duration = duration;
        this.endingDay = endingDay;
        this.endingTime = endingTime;
        this.programmationTemplate = programmationTemplate;
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

    public int getSpanType() {
        return spanType;
    }

    public void setSpanType(int spanType) {
        this.spanType = spanType;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
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

    public int getEndingDay() {
        return endingDay;
    }

    public void setEndingDay(int endingDay) {
        this.endingDay = endingDay;
    }

    public Long getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }

    public ProgrammationTemplateEntity getProgrammationTemplate() {
        return programmationTemplate;
    }

    public void setProgrammationTemplate(ProgrammationTemplateEntity programmationTemplate) {
        this.programmationTemplate = programmationTemplate;
    }
}
