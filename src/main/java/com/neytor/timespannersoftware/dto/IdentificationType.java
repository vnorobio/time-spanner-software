package com.neytor.timespannersoftware.dto;

public class IdentificationType {

    private Long id;

    private String code;

    private String description;

    private String shortenedForm;

    public IdentificationType() {
        // Empty constructor
    }

    public IdentificationType(Long id, String code, String description, String shortenedForm) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.shortenedForm = shortenedForm;
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

    public String getShortenedForm() {
        return shortenedForm;
    }

    public void setShortenedForm(String shortenedForm) {
        this.shortenedForm = shortenedForm;
    }
}
