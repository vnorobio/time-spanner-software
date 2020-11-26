package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "estates")
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
