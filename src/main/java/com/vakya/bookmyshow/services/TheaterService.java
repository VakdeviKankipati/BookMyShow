package com.vakya.bookmyshow.services;

import com.vakya.bookmyshow.transformers.TheaterTransformer;
import com.vakya.bookmyshow.dtos.RequestDto.TheaterEntryDto;
import com.vakya.bookmyshow.dtos.RequestDto.TheaterSeatsDto;
import com.vakya.bookmyshow.enums.SeatType;
import com.vakya.bookmyshow.models.Theater;
import com.vakya.bookmyshow.models.TheaterSeat;
import com.vakya.bookmyshow.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto){


        Theater theater = TheaterTransformer.convertDtoToEntity(theaterEntryDto);
        theaterRepository.save(theater);

        return "Theater Added successfully";
    }

    public String addTheaterSeats(TheaterSeatsDto theaterSeatsEntryDto){

        //We need to save the TheaterSeat Entity
        int columns = theaterSeatsEntryDto.getNoOfSeatsIn1Row();
        int noOfClassicSeats = theaterSeatsEntryDto.getNofOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsEntryDto.getNoOfPremiumSeats();

        String location = theaterSeatsEntryDto.getLocation();

        Theater theater = theaterRepository.findByLocation(location);

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        System.out.println("The value of noOfPremium Seats"+noOfPremiumSeats);

        int counter = 1;
        char ch = 'A';

        for(int count = 1;count<=noOfClassicSeats;count++){

            String seatNo = counter+"";
            seatNo = seatNo + ch;

            ch++;

            if((ch-'A')==columns){
                ch = 'A';
                counter++;
            }
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theaterSeatList.add(theaterSeat);
        }

        //Lets to the same for the premium seats
        for(int count=1;count<=noOfPremiumSeats;count++){
            String seatNo = counter+"";
            seatNo = seatNo + ch;
            ch++;
            if((ch-'A')==columns){
                ch = 'A';
                counter++;
            }
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setSeatNo(seatNo);
            System.out.println("The seatNo is "+seatNo);
            theaterSeatList.add(theaterSeat);
        }

        theaterRepository.save(theater);

        return "Theater Seats have been successfully added";
    }
}
