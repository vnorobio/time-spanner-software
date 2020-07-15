package com.neytor.timespannersoftware.dto;

public class Identification {

    private Long id;

    private Person person;

    private IdentificationType identificationType;

    private Country country;

    private String identificationNumber;

    private Boolean active;

    public Identification() {
        // Empty constructor
    }

    public Identification(Long id, Person person, IdentificationType identificationType, Country country, String identificationNumber, Boolean active) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
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
