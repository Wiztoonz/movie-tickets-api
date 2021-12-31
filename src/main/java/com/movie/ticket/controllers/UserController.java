package com.movie.ticket.controllers;

import com.movie.ticket.dto.RoleDto;
import com.movie.ticket.dto.UserDto;
import com.movie.ticket.entities.User;
import com.movie.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registration(@RequestBody User user) {
        User savedUser = userService.save(user);
        UserDto userDto = new UserDto(
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                savedUser.getRoles().stream()
                        .map(role -> new RoleDto(role.getRoleName()))
                        .collect(Collectors.toList())
                );
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}