package piotr.hadala.buy4wheels.domain.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import piotr.hadala.buy4wheels.domain.user.UserService;
import piotr.hadala.buy4wheels.domain.user.dto.UserRegistrationDto;


@RestController
@RequestMapping(
        path = "/api/register",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        })
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserRegistrationDto> addBook(@RequestBody UserRegistrationDto userRegistrationDto) {
        UserRegistrationDto addedUser = userService.registerUserWithDefaultRole(userRegistrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }
}
