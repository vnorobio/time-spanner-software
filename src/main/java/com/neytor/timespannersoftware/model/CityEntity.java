package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    private String code;

    private String description;

    @ManyToOne
    @JoinColumn(name = "estate_id", referencedColumnName = "estate_id", insertable = false, updatable = false)
    private EstateEntity estate;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
    private CountryEntity country;

    public CityEntity() {
        // Empty constructor
    }

    public CityEntity(Long id, String code, String description, EstateEntity estate, CountryEntity country) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.estate = estate;
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

    public EstateEntity getEstate() {
        return estate;
    }

    public void setEstate(EstateEntity estate) {
        this.estate = estate;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
