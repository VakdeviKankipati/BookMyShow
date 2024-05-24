package com.vakya.bookmyshow.transformers;

import com.vakya.bookmyshow.dtos.RequestDto.TheaterEntryDto;
import com.vakya.bookmyshow.models.Theater;

public class TheaterTransformer {
    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        Theater theater = Theater.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();

        return theater;
    }
}
