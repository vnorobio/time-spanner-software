package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
