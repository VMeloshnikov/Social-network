package ru.skillbox.diplom.group33.social.service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.diplom.group33.social.service.config.security.jwt.JwtTokenProvider;
import ru.skillbox.diplom.group33.social.service.dto.AuthenticateDto;
import ru.skillbox.diplom.group33.social.service.dto.AuthenticateResponseDto;
import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;
import ru.skillbox.diplom.group33.social.service.model.User;
import ru.skillbox.diplom.group33.social.service.repository.UserRepository;
import ru.skillbox.diplom.group33.social.service.service.AuthService;

@RestController
@RequestMapping(value = "/")
public class AuthControllerImpl implements AuthController {


    private final AuthService authService;

    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    @Override
    public ResponseEntity<AuthenticateResponseDto> login(@RequestBody AuthenticateDto authenticateDto) {
        final AuthenticateResponseDto response = authService.login(authenticateDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/logout")
    @Override
    public void logout() {

    }

    @PostMapping("registration")
    @Override
    public void register(@RequestBody RegistrationDto registrationDto) {
        authService.register(registrationDto);
    }
}
