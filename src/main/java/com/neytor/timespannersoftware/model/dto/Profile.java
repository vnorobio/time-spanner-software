package com.neytor.timespannersoftware.model.dto;

public class Profile {

    private Long id;

    private String description;

    public Profile() {
        // Empty constructor
    }

    public Profile(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
