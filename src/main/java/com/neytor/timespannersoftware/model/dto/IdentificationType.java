package com.neytor.timespannersoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IdentificationType {

    private Long id;

    @NonNull
    private String code;

    @NonNull
    private String description;

    @NonNull
    private String shortenedForm;

    public IdentificationType(@JsonProperty("id") Long id,
                              @JsonProperty("code") @NonNull String code,
                              @JsonProperty("description") @NonNull String description,
                              @JsonProperty("shortenedForm") @NonNull String shortenedForm) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.shortenedForm = shortenedForm;
    }
}
