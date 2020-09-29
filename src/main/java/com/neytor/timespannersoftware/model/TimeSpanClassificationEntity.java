package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "time_span_classifications")
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
    @Column(name = "time_classification_id")
    private TimeClassificationEntity timeClassification;

    public TimeSpanClassificationEntity() {
        // Empty constructor
    }

    public TimeSpanClassificationEntity(Long id, TimeSpanEntity timeSpan, TimeClassificationEntity timeClassification) {
        this.id = id;
        this.timeSpan = timeSpan;
        this.timeClassification = timeClassification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TimeSpanEntity getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(TimeSpanEntity timeSpan) {
        this.timeSpan = timeSpan;
    }

    public TimeClassificationEntity getTimeClassification() {
        return timeClassification;
    }

    public void setTimeClassification(TimeClassificationEntity timeClassification) {
        this.timeClassification = timeClassification;
    }
}
