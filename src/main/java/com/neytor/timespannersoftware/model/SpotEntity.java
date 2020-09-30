package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "spots")
public class SpotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private Long id;

    private String code;

    private String description;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    private LocationEntity location;

    @ManyToOne
    @JoinColumn(name = "territorial_division_id", referencedColumnName = "territorial_division_id", insertable = false, updatable = false)
    private CityEntity territorialDivision;

    public SpotEntity() {
        // Empty constructor
    }

    public SpotEntity(Long id, String code, String description, LocationEntity location, CityEntity territorialDivision) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.location = location;
        this.territorialDivision = territorialDivision;
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

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public CityEntity getTerritorialDivision() {
        return territorialDivision;
    }

    public void setTerritorialDivision(CityEntity territorialDivision) {
        this.territorialDivision = territorialDivision;
    }
}
