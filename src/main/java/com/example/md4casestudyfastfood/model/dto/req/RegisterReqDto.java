package com.example.md4casestudyfastfood.model.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegisterReqDto {
    private String name;
    private String phoneNumber;
    private LocalDate dob;
    private String address;
    private String email;
    private String password;
}
