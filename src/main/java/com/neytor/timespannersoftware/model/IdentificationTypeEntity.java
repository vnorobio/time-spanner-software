package com.neytor.timespannersoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public IdentificationTypeEntity() {
        // Empty constructor
    }

    public IdentificationTypeEntity(Long id, String code, String description, String shortenedForm) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.shortenedForm = shortenedForm;
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
}
