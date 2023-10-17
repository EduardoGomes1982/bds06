package com.devsuperior.movieflix.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OAuthCustomError {
    private String error;

    @JsonProperty(value = "error_description")
    private String errorDescription;
}
