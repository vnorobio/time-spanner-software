package com.neytor.timespannersoftware.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "concepts")
public class ConceptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concept_id")
    private Long id;

    private String code;

    private String description;

    private BigDecimal ratio;

    public ConceptEntity() {
        // Empty constructor
    }

    public ConceptEntity(Long id, String code, String description, BigDecimal ratio) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.ratio = ratio;
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

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}
