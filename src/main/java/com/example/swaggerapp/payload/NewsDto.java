package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDto {

    private String message;

    private String comment;

    private String created_date;

    private boolean seen;

    private Integer sender_id;

    private String description;

    public NewsDto(boolean seen) {
        this.seen = seen;
    }

    public NewsDto(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
