package ru.skillbox.diplom.group33.social.service.controllers;

import org.springframework.http.ResponseEntity;
import ru.skillbox.diplom.group33.social.service.dto.AuthenticateDto;
import ru.skillbox.diplom.group33.social.service.dto.AuthenticateResponseDto;
import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;

public interface AuthController {
    ResponseEntity<AuthenticateResponseDto> login(AuthenticateDto authenticateDto);
    void logout();
    void register(RegistrationDto registrationDto);
}
