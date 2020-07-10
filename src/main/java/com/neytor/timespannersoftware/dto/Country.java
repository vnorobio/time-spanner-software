package com.neytor.timespannersoftware.dto;

public class Country {

    private Long id;

    private String name;

    private Integer numericCode;

    private String alpha2Code;

    private String alpha3Code;

    public Country() {
        // Empty constructor
    }

    public Country(Long id, String name, Integer numericCode, String alpha2Code, String alpha3Code) {
        this.id = id;
        this.name = name;
        this.numericCode = numericCode;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }
}
