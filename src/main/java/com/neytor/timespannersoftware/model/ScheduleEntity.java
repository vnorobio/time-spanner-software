package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

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

    @Column(name = "ordinary_time_lapse")
    private Long ordinaryTimeLapse;

    @Column(name = "rest_time")
    private Long restTime;

    @Column(name = "template_code")
    private String templateCode;

    public ScheduleEntity() {
        // Empty constructor
    }

    public ScheduleEntity(Long id, SpotEntity spot, PersonEntity person, ContractEntity contract, int timeOffType, Long ordinaryTimeLapse, Long restTime, String templateCode) {
        this.id = id;
        this.spot = spot;
        this.person = person;
        this.contract = contract;
        this.timeOffType = timeOffType;
        this.ordinaryTimeLapse = ordinaryTimeLapse;
        this.restTime = restTime;
        this.templateCode = templateCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpotEntity getSpot() {
        return spot;
    }

    public void setSpot(SpotEntity spot) {
        this.spot = spot;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }

    public int getTimeOffType() {
        return timeOffType;
    }

    public void setTimeOffType(int timeOffType) {
        this.timeOffType = timeOffType;
    }

    public Long getOrdinaryTimeLapse() {
        return ordinaryTimeLapse;
    }

    public void setOrdinaryTimeLapse(Long ordinaryTimeLapse) {
        this.ordinaryTimeLapse = ordinaryTimeLapse;
    }

    public Long getRestTime() {
        return restTime;
    }

    public void setRestTime(Long restTime) {
        this.restTime = restTime;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
