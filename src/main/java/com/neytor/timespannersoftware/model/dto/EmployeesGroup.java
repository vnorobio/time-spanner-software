package com.neytor.timespannersoftware.model.dto;

public class EmployeesGroup {

    private Long id;

    private String code;

    private String description;

    public EmployeesGroup() {
        // Empty constructor
    }

    public EmployeesGroup(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
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
}
