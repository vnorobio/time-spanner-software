package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class IdentificationType {

    private Long id;

    private String code;

    private String description;

    private String shortenedForm;

}
