package com.neytor.timespannersoftware.dto;

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

    public Person() {
        // Empty constructor
    }

    public Person(Long id, String firstName, String secondName, String firstSurname, String secondSurname, String fullName, IdentificationType identificationType, String identificationNumber, Integer gender, Integer maritalStatus, String address, String email, String phoneNumber) {
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

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
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
