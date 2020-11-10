package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;

@Value
@Builder
public class Profile {

    private Long id;

    private String description;

}
