package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {

    private String comment;

    private Integer news_id;

    private Integer user_id;

    private String send_date;

    public CommentDto(String comment) {
        this.comment = comment;
    }
}
