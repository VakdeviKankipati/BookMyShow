package com.vakya.bookmyshow.dtos.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {
    private String responseMessage;

    private LocalTime showTime;

    private Date showDate;

    private String movieName;

    private String theaterName;

    private String bookedSeats;

    private String location;

    private int totalPrice;

    public void setResponseMessage(String message) {
    }
}
