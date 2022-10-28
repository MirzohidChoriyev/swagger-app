package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Card;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public ApiResponse save(Card cardDto) throws ParseException {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.now();
        localDate2 = localDate2.plusYears(5);
        String dateStr2 = localDate2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dateStr1 = localDate1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        cardDto.setTerm_date(dateStr2);
        cardDto.setOpen_date(dateStr1);

        cardDto.setCard_name(cardDto.getBank_name());
        cardDto.setEmbossed_name(cardDto.getEmbossed_name().toUpperCase());

        Date date = new Date(System.currentTimeMillis());
        cardDto.setCreateDate(date);

        cardRepository.save(cardDto);
        return new ApiResponse("Save card", true, cardDto);
    }

    public ApiResponse getByCardUserId(Integer userId) {
        Card card = cardRepository.findByCardUserIdNQ(userId);
        return new ApiResponse("Get by card user id", true, card);
    }
}
