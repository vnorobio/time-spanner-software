package com.neytor.timespannersoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person {

    private Long id;

    @NonNull
    private String firstName;

    private String secondName;

    @NonNull
    private String firstSurname;

    private String secondSurname;

    private String fullName;

    @NonNull
    private IdentificationType identificationType;

    @NonNull
    private String identificationNumber;

    @NonNull
    private Integer gender;

    @NonNull
    private Integer maritalStatus;

    @NonNull
    private String address;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    public Person(@JsonProperty("id") Long id,
                  @JsonProperty("firstName") @NonNull String firstName,
                  @JsonProperty("secondName") String secondName,
                  @JsonProperty("firstSurname") @NonNull String firstSurname,
                  @JsonProperty("secondSurname") String secondSurname,
                  @JsonProperty("fullName") String fullName,
                  @JsonProperty("identificationType") @NonNull IdentificationType identificationType,
                  @JsonProperty("identificationNumber") @NonNull String identificationNumber,
                  @JsonProperty("gender") @NonNull Integer gender,
                  @JsonProperty("maritalStatus") @NonNull Integer maritalStatus,
                  @JsonProperty("address") @NonNull String address,
                  @JsonProperty("email") @NonNull String email,
                  @JsonProperty("phoneNumber") @NonNull String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = !secondName.isBlank() ? secondName : "";
        this.firstSurname = firstSurname;
        this.secondSurname = !secondSurname.isBlank() ? secondSurname : "";
        this.fullName = !fullName.isBlank() ? fullName : firstName + " " + secondName + " " + firstSurname + " " + secondSurname;;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
