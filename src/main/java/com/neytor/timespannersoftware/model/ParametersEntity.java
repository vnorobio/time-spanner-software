package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
@Data
public class ParametersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parameters_id")
    private Long id;

    @Column(name = "maximum_work_time_per_day")
    private Long maximumWorkTimePerDay;

    @Column(name = "maximum_work_time_per_week")
    private Long maximumWorkTimePerWeek;

    @Column(name = "manimum_rest_time_per_week")
    private Long manimumRestTimePerWeek;

    @ManyToOne
    @JoinColumn(name = "working_hours_concept", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity workingHoursConcept;

    @ManyToOne
    @JoinColumn(name = "overtime_surcharge_concept", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity overtimeSurchargeConcept;

    @ManyToOne
    @JoinColumn(name = "night_surcharge_concept", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity nightSurchargeConcept;

    @ManyToOne
    @JoinColumn(name = "holiday_surcharge_concept", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity holidaySurchargeConcept;

    @ManyToOne
    @JoinColumn(name = "sunday_surcharge_concept", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity sundaySurchargeConcept;

    @ManyToOne
    @JoinColumn(name = "compensation_surcharge_concept", referencedColumnName = "concept_id", insertable = false, updatable = false)
    private ConceptEntity compensationSurchargeConcept;

}
