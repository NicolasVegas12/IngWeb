package com.nvegas.ingwebapi.models.dto.response.error;

import lombok.Getter;
import lombok.Setter;

public class ErrorMessageResponse {

    public ErrorMessageResponse(String message, String error, Integer statusCode, String detail) {
        this.message = message;
        this.error = error;
        this.statusCode = statusCode;
        this.detail = detail;
    }

    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String error;

    @Getter
    @Setter
    private String detail;
    @Getter
    @Setter
    private Integer statusCode;
}
