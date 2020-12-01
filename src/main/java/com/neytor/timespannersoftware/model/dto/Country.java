package com.neytor.timespannersoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Country {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer numericCode;

    @NonNull
    private String alpha2Code;

    @NonNull
    private String alpha3Code;

    @JsonCreator
    public Country(@JsonProperty("id") Long id,
                   @JsonProperty("name") @NonNull String name,
                   @JsonProperty("numericCode") @NonNull Integer numericCode,
                   @JsonProperty("alpha2Code") @NonNull String alpha2Code,
                   @JsonProperty("alpha3Code") @NonNull String alpha3Code) {
        this.id = id;
        this.name = name;
        this.numericCode = numericCode;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
    }
}
