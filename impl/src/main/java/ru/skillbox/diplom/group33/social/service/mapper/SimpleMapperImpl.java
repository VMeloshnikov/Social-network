package ru.skillbox.diplom.group33.social.service.mapper;

import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;
import ru.skillbox.diplom.group33.social.service.dto.UserDto;
import ru.skillbox.diplom.group33.social.service.model.User;

import java.util.Date;

public class SimpleMapperImpl implements SimpleMapper{
    @Override
    public UserDto sourceToUserDto(RegistrationDto registrationDto) {
        UserDto user = new UserDto();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword1());
        return user;
    }

    @Override
    public RegistrationDto sourceToRegistrationDto(UserDto userDto) {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName(userDto.getFirstName());
        registrationDto.setLastName(userDto.getLastName());
        registrationDto.setEmail(userDto.getEmail());
        registrationDto.setPassword1(userDto.getPassword());
        registrationDto.setPassword2(userDto.getPassword());
        return registrationDto;
    }

    @Override
    public User sourceRegToUser(RegistrationDto dto) {
        User user = new User();
        user.setUserName(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getLastName());
        user.setPassword(dto.getPassword1());
        user.setCreated(new Date());
        return user;
    }
}
