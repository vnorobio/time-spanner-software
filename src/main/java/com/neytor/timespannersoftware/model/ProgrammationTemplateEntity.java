package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "programmation_templates")
public class ProgrammationTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programmation_template_id")
    private Long id;

    private String code;

    private String description;

    public ProgrammationTemplateEntity() {
        // Empty constructor
    }

    public ProgrammationTemplateEntity(Long id, String code, String description) {
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
