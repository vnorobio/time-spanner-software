package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "spots")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
    private CityEntity city;

}
