package ru.skillbox.diplom.group33.social.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class AuthenticateResponseDto {
    private String accessToken;
    private String refreshToken;
}
