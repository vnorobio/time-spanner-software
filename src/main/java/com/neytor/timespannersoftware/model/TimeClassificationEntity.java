package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "time_classifications")
@Data
public class TimeClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_classification_id")
    private Long id;

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
