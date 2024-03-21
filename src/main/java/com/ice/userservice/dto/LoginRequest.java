package com.ice.userservice.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class LoginRequest {

    private String mobileNumber;

    private String password;

}
