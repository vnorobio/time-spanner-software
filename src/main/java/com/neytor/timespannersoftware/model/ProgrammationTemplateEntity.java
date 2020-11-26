package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "programmation_templates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammationTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programmation_template_id")
    private Long id;

    private String code;

    private String description;

    @Column(name = "time_off_type")
    private int timeOffType;

    @Column(name = "total_time")
    private Long totalTime;

    @Column(name = "working_time")
    private Long workingTime;

    @Column(name = "rest_time")
    private Long restTime;

}
