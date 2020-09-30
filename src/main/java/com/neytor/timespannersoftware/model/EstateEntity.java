package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "estates")
public class EstateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estate_id")
    private Long id;

    private String code;

    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
    private CountryEntity country;

    public EstateEntity() {
        // Empty constructor
    }

    public EstateEntity(Long id, String code, String description, CountryEntity country) {
        this.id = id;
        this.code = code;
        this.description = description;
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

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

}
