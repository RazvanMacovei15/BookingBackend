package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import siemens.booking.dto.UserDto;
import siemens.booking.entity.User;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.UserService;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private Mapper<User, UserDto> userMapper;

    @PostMapping(path="/users")
    public UserDto createUser(@RequestBody UserDto userDto){
        User user = userMapper.mapFrom(userDto);
        User savedUser = userService.save(user);
        return userMapper.mapTo(savedUser);
    }
}
