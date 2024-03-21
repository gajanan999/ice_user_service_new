package com.ice.userservice.controller;

import com.ice.userservice.controller.UserController;
import com.ice.userservice.dto.RestResponse;
import com.ice.userservice.dto.UserDto;
import com.ice.userservice.exception.NoRecordFound;
import com.ice.userservice.exception.RecordAlreadyExistsException;
import com.ice.userservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    void testGetAllUsers() {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        when(userService.getAllUsers()).thenReturn(List.of(new UserDto(), new UserDto()));

        ResponseEntity<?> responseEntity = userController.getAllUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testCreateUser() throws RecordAlreadyExistsException {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        UserDto userDto = new UserDto();
        userDto.setUserName("testuser");

        when(userService.createUser(userDto)).thenReturn(userDto);

        ResponseEntity<?> responseEntity = userController.createUser(userDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateUser() throws NoRecordFound {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setUserName("testuser");

        when(userService.updateUser(userDto)).thenReturn(userDto);

        ResponseEntity<?> responseEntity = userController.updateUser(userDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteUser() throws NoRecordFound {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        UUID userId = UUID.randomUUID();

        ResponseEntity<?> responseEntity = userController.deleteUser(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
