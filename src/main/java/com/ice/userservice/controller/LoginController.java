package com.ice.userservice.controller;

import com.ice.userservice.constant.ApiStatus;
import com.ice.userservice.dto.LoginRequest;
import com.ice.userservice.dto.RestResponse;
import com.ice.userservice.dto.UserDto;
import com.ice.userservice.exception.RecordAlreadyExistsException;
import com.ice.userservice.service.LoginService;
import com.ice.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Validated
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody LoginRequest loginRequest){

        try{
            logger.debug("Got the request for /login doLogin");
            UserDto userDto = loginService.doLogin(loginRequest);
            return ResponseEntity.ok(userDto);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
