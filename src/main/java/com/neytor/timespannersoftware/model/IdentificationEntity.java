package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "identifications")
public class IdentificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "identification_type", referencedColumnName = "identification_type_id", insertable = false, updatable = false)
    private IdentificationTypeEntity identificationType;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
    private CountryEntity country;

    @Column(name = "identification_number")
    private String identificationNumber;

    private Boolean active;

    public IdentificationEntity() {
        // Empty constructor
    }

    public IdentificationEntity(Long id, PersonEntity person, IdentificationTypeEntity identificationType, CountryEntity country, String identificationNumber, Boolean active) {
        this.id = id;
        this.person = person;
        this.identificationType = identificationType;
        this.country = country;
        this.identificationNumber = identificationNumber;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public IdentificationTypeEntity getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationTypeEntity identificationType) {
        this.identificationType = identificationType;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
