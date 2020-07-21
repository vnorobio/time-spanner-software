package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "costs_centers")
public class CostsCenterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cost_center_id")
    private Long id;

    private String code;

    private String description;

    public CostsCenterEntity() {
        // Empty constructor
    }

    public CostsCenterEntity(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
