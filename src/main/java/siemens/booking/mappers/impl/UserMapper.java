package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.UserDto;
import siemens.booking.entity.User;
import siemens.booking.mappers.Mapper;

@Component
public class UserMapper implements Mapper<User, UserDto> {
    private ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public User mapFrom(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    @Override
    public UserDto mapTo(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
