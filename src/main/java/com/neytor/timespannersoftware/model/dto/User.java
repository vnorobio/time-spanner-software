package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class User {

    private Long id;

    private String login;

    private String password;

    private String name;

    private String email;

    private Boolean active;

}
