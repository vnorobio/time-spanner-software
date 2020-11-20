package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "programmation_sequences")
@Data
public class ProgrammationSequenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programmation_sequence_id")
    private Long id;

    private String code;

    private String description;

}
