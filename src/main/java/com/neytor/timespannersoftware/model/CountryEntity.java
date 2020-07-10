package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "countries")
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

    public CountryEntity() {
        // Empty constructor
    }

    public CountryEntity(Long id, String name, Integer numericCode, String alpha2Code, String alpha3Code) {
        this.id = id;
        this.name = name;
        this.numericCode = numericCode;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }
}
