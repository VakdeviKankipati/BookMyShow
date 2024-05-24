package com.vakya.bookmyshow.Transformers;

import com.vakya.bookmyshow.dtos.RequestDto.AddShowDto;
import com.vakya.bookmyshow.models.Show;

public class ShowTransformer {
    public static Show convertDtoToEntity(AddShowDto addShowDto){

        Show show = Show.builder().localTime(addShowDto.getShowStartTime())
                .date(addShowDto.getShowDate()).build();

        return show;

    }
}
