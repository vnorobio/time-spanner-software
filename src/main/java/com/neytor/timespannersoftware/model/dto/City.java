package com.neytor.timespannersoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class City {

    private Long id;

    @NonNull
    private String code;

    @NonNull
    private String description;

    @NonNull
    private Estate estate;

    @NonNull
    private Country country;

    @JsonCreator
    public City(@JsonProperty("id") Long id,
                @JsonProperty("code") @NonNull String code,
                @JsonProperty("description") @NonNull String description,
                @JsonProperty("estate") @NonNull Estate estate,
                @JsonProperty("country") @NonNull Country country) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.estate = estate;
        this.country = country;
    }
}
