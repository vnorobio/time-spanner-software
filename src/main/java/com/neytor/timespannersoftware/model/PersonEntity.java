package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "first_surname")
    private String firstSurname;

    @Column(name = "second_surname")
    private String secondSurname;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "identification_type", referencedColumnName = "identification_type_id", insertable = false, updatable = false)
    private IdentificationTypeEntity identificationType;

    @Column(name = "identification_number")
    private String identificationNumber;

    private Integer gender;

    @Column(name = "marital_status")
    private Integer maritalStatus;

    private String address;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

}
