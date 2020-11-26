package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "programmation_sequences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammationSequenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programmation_sequence_id")
    private Long id;

    private String code;

    private String description;

}
