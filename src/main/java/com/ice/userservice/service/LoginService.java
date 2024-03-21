package com.ice.userservice.service;


import com.ice.userservice.dao.UserRepository;
import com.ice.userservice.dto.LoginRequest;
import com.ice.userservice.dto.UserDto;
import com.ice.userservice.entity.User;
import com.ice.userservice.mapper.EntityToDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * LoginService is used to handle the login nto frontend
 */
@Service
public class LoginService {

    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto doLogin(LoginRequest loginRequest){
        User user = userRepository.findByMobileNumberAndPassword(loginRequest.getMobileNumber(),loginRequest.getPassword());
        return EntityToDtoMapper.INSTANCE.userToUserDto(user);
    }

}
