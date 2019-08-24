package com.projekat.poslovna.controller.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
class ExceptionResponse {

    private String errorMessage;

    private HttpStatus status;

    @JsonProperty("data")
    private Object data;

    public ExceptionResponse(String errorMessage, HttpStatus status) {
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public void setErrors(Object errors) {
        this.data = errors;
    }

}
