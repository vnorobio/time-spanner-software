package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "spot_id", referencedColumnName = "spot_id", insertable = false, updatable = false)
    private SpotEntity spot;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
    private ContractEntity contract;

    @Column(name = "time_off_type")
    private int timeOffType;

    @Column(name = "total_time")
    private Long totalTime;

    @Column(name = "working_time")
    private Long workingTime;

    @Column(name = "rest_time")
    private Long restTime;

    @Column(name = "template_code")
    private String templateCode;

}
