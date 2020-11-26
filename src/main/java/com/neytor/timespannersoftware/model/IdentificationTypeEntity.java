package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "identification_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identification_type_id")
    private Long id;

    private String code;

    private String description;

    @Column(name = "shortened_form")
    private String shortenedForm;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
    private CountryEntity country;

}
