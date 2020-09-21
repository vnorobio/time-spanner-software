package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "programmation_templates")
public class ProgrammationTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programmation_template_id")
    private Long id;

    private String code;

    private String description;

    @Column(name = "time_off_type")
    private int timeOffType;

    @Column(name = "ordinary_time_lapse")
    private Long ordinaryTimeLapse; 

    @Column(name = "rest_time")
    private Long restTime;

    public ProgrammationTemplateEntity() {
        // Empty constructor
    }

    public ProgrammationTemplateEntity(Long id, String code, String description, int timeOffType, Long ordinaryTimeLapse, Long restTime) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.timeOffType = timeOffType;
        this.ordinaryTimeLapse = ordinaryTimeLapse;
        this.restTime = restTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeOffType() {
        return timeOffType;
    }

    public void setTimeOffType(int timeOffType) {
        this.timeOffType = timeOffType;
    }

    public Long getOrdinaryTimeLapse() {
        return ordinaryTimeLapse;
    }

    public void setOrdinaryTimeLapse(Long ordinaryTimeLapse) {
        this.ordinaryTimeLapse = ordinaryTimeLapse;
    }

    public Long getRestTime() {
        return restTime;
    }

    public void setRestTime(Long restTime) {
        this.restTime = restTime;
    }
}
