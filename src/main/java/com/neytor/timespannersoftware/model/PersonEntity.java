package com.neytor.timespannersoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
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

    public PersonEntity() {
        // Empty constructor
    }

    public PersonEntity(Long id, String firstName, String secondName, String firstSurname, String secondSurname, String fullName, IdentificationTypeEntity identificationType, String identificationNumber, Integer gender, Integer maritalStatus, String address, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.fullName = fullName;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.setFullName();
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
        this.setFullName();
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
        this.setFullName();
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
        this.setFullName();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.firstSurname);
        if (!this.secondSurname.isEmpty()) {
            stringBuilder.append( " " + this.secondSurname);
        }
        stringBuilder.append(this.firstName);
        if (!this.secondName.isEmpty()) {
            stringBuilder.append( " " + this.secondName);
        }
        this.fullName =  stringBuilder.toString();
    }

    public IdentificationTypeEntity getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationTypeEntity identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
