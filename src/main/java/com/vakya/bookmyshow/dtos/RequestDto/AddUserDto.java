package com.vakya.bookmyshow.dtos.RequestDto;

import lombok.Data;

@Data
public class AddUserDto {

    private String name;
    private Integer age;
    private String mobNo;
    private String emailId;
}
