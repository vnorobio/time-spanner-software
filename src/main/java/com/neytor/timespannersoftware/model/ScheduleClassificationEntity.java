package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "schedule_classifications")
@Data
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

}
