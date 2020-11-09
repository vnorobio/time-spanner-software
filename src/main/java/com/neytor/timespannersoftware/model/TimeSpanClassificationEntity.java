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
    @JoinColumn(name = "time_span_id", referencedColumnName = "time_span_id", insertable = false, updatable = false)
    private TimeSpanEntity timeSpan;

    @ManyToOne
    @JoinColumn(name = "time_classification_id", referencedColumnName = "time_classification_id", insertable = false, updatable = false)
    private TimeClassificationEntity timeClassification;

}
