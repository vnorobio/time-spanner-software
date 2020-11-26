package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "time_spans")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
