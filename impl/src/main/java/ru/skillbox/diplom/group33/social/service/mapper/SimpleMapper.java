package ru.skillbox.diplom.group33.social.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;
import ru.skillbox.diplom.group33.social.service.dto.UserDto;
import ru.skillbox.diplom.group33.social.service.model.User;

@Mapper
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);

    UserDto sourceToUserDto(RegistrationDto registrationDto);
    RegistrationDto sourceToRegistrationDto(UserDto userDto);

    User sourceRegToUser(RegistrationDto dto);
}
