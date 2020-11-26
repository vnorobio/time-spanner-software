package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "concepts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConceptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concept_id")
    private Long id;

    private String code;

    private String description;

    private BigDecimal ratio;

}
