package com.neytor.timespannersoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "identification_type")
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

    public IdentificationTypeEntity() {
        // Empty constructor
    }

    public IdentificationTypeEntity(Long id, String code, String description, String shortenedForm, CountryEntity country) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.shortenedForm = shortenedForm;
        this.country = country;
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

    public String getShortenedForm() {
        return shortenedForm;
    }

    public void setShortenedForm(String shortenedForm) {
        this.shortenedForm = shortenedForm;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
