package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sequence_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SequenceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequence_detail_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programmation_sequence_id", referencedColumnName = "programmation_sequence_id", insertable = false, updatable = false)
    private ProgrammationSequenceEntity programmationSequence;

    private Integer order;

    @ManyToOne
    @JoinColumn(name = "programmation_template_id", referencedColumnName = "programmation_template_id", insertable = false, updatable = false)
    private ProgrammationTemplateEntity programmationTemplate;

}
