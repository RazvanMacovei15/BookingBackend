package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siemens.booking.dto.UserDto;
import siemens.booking.entity.User;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.UserService;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    private final UserService userService;
    private Mapper<User, UserDto> userMapper;

    @PostMapping(path = "/user")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapFrom(userDto);
        User savedUser = userService.save(user);
        return userMapper.mapTo(savedUser);
    }

    @GetMapping(path="/user")
    public UserDto getUser() {
        User user = userService.getUser(1L);
        return userMapper.mapTo(user);
    }
}
