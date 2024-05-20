package com.vakya.bookmyshow.dtos.RequestDto;

import lombok.Data;

@Data
public class TheaterSeatsDto {
    private int noOfSeatsIn1Row;
    private int nofOfClassicSeats;
    private int noOfPremiumSeats;
    private String location;
}
