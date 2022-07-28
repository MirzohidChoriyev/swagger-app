package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private Integer request;
    private Object object;

    public ApiResponse(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}

