package com.axity.axityapi.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URI;

@Data
@AllArgsConstructor
public class ProblemDetails {
    private URI type;
    private String title;
    private int status;
    private String timestamp;
    private String detail;
}
