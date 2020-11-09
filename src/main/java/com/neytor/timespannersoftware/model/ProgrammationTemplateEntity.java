package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "programmation_templates")
@Data
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

}
