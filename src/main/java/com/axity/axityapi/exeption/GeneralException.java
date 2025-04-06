package com.axity.axityapi.exeption;

import lombok.Data;

import java.net.URI;

@Data
public class GeneralException extends RuntimeException {
    private final URI type;
    private final String message;
    private final int status;
    private final String timestamp;
    private final String detail;

    public GeneralException(URI type, String title, int status, String timestamp, String detail) {
        super(title);
        this.type = type;
        this.message = title;
        this.status = status;
        this.timestamp = timestamp;
        this.detail = detail;
    }

}
