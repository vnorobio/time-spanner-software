package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_classifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_classification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", insertable = false, updatable = false)
    private ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "schedule_detail_id", referencedColumnName = "schedule_detail_id", insertable = false, updatable = false)
    private ScheduleDetailEntity scheduleDetail;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "start_time")
    private Long startTime;

    private Long duration;

    @Column(name = "ending_date", columnDefinition = "DATE")
    private LocalDate endingDate;

    @Column(name = "ending_time")
    private Long endingTime;

    @Column(name = "is_overtime")
    private Boolean isOvertime;

    @Column(name = "is_nigth")
    private Boolean isNigth;

    @Column(name = "is_compensatory")
    private Boolean isCompensatory;

}
