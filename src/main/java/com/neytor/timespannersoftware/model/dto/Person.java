package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Person {

    private Long id;

    private String firstName;

    private String secondName;

    private String firstSurname;

    private String secondSurname;

    private String fullName;

    private IdentificationType identificationType;

    private String identificationNumber;

    private Integer gender;

    private Integer maritalStatus;

    private String address;

    private String email;

    private String phoneNumber;

}
