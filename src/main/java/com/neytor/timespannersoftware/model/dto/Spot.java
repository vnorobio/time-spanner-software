package com.neytor.timespannersoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Spot {

    private Long id;

    @NonNull
    private String code;

    @NonNull
    private String description;

    @NonNull
    private Location location;

    @NonNull
    private City city;

    public Spot(@JsonProperty("id") Long id,
                @JsonProperty("code") @NonNull String code,
                @JsonProperty("description") @NonNull String description,
                @JsonProperty("location") @NonNull Location location,
                @JsonProperty("city") @NonNull City city) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.location = location;
        this.city = city;
    }
}
