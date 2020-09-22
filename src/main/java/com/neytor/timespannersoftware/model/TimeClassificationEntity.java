package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "time_classifications")
public class TimeClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_classification_id")
    private Long id;

    @Column(name = "start_day")
    private int startDay;

    @Column(name = "start_time")
    private Long startTime;

    private Long duration;

    @Column(name = "ending_day")
    private int endingDay;

    @Column(name = "ending_time")
    private Long endingTime;

    @Column(name = "is_overtime")
    private Boolean isOvertime;

    @Column(name = "is_nigth")
    private Boolean isNigth;

    @Column(name = "is_compensatory")
    private Boolean isCompensatory;

    public TimeClassificationEntity() {
        // Empty constructor
    }

    public TimeClassificationEntity(Long id, int startDay, Long startTime, Long duration, int endingDay, Long endingTime, Boolean isOvertime, Boolean isNigth, Boolean isCompensatory) {
        this.id = id;
        this.startDay = startDay;
        this.startTime = startTime;
        this.duration = duration;
        this.endingDay = endingDay;
        this.endingTime = endingTime;
        this.isOvertime = isOvertime;
        this.isNigth = isNigth;
        this.isCompensatory = isCompensatory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getOvertime() {
        return isOvertime;
    }

    public void setOvertime(Boolean overtime) {
        isOvertime = overtime;
    }

    public Boolean getNigth() {
        return isNigth;
    }

    public void setNigth(Boolean nigth) {
        isNigth = nigth;
    }

    public Boolean getCompensatory() {
        return isCompensatory;
    }

    public void setCompensatory(Boolean compensatory) {
        isCompensatory = compensatory;
    }
}
