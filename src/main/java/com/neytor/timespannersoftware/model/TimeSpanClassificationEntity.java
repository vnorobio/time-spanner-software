package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "time_span_classifications")
@Data
public class TimeSpanClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_span_classification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programmation_template_id", referencedColumnName = "programmation_template_id", insertable = false, updatable = false)
    private ProgrammationTemplateEntity programmationTemplate;

    @ManyToOne
    @JoinColumn(name = "time_span_id", referencedColumnName = "time_span_id", insertable = false, updatable = false)
    private TimeSpanEntity timeSpan;

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

}
