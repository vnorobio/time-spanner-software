package com.neytor.timespannersoftware.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Data
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "numeric_code")
    private Integer numericCode;

    @Column(name = "alpha_2_code")
    private String alpha2Code;

    @Column(name = "alpha_3_code")
    private String alpha3Code;

}
