package ru.skillbox.diplom.group33.social.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
