package com.neytor.timespannersoftware.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "schedule_classifications")
public class ScheduleClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_classification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_detail_id", referencedColumnName = "schedule_detail_id", insertable = false, updatable = false)
    private ScheduleDetailEntity scheduleDetail;

    @ManyToOne
    @JoinColumn(name = "time_classification_id", referencedColumnName = "time_classification_id", insertable = false, updatable = false)
    private TimeClassificationEntity timeClassification;

    public ScheduleClassificationEntity() {
        // Empty constructor
    }

    public ScheduleClassificationEntity(Long id, ScheduleDetailEntity scheduleDetail, TimeClassificationEntity timeClassification) {
        this.id = id;
        this.scheduleDetail = scheduleDetail;
        this.timeClassification = timeClassification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScheduleDetailEntity getScheduleDetail() {
        return scheduleDetail;
    }

    public void setScheduleDetail(ScheduleDetailEntity scheduleDetail) {
        this.scheduleDetail = scheduleDetail;
    }

    public TimeClassificationEntity getTimeClassification() {
        return timeClassification;
    }

    public void setTimeClassification(TimeClassificationEntity timeClassification) {
        this.timeClassification = timeClassification;
    }
}
