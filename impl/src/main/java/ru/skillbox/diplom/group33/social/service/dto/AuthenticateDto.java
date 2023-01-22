package ru.skillbox.diplom.group33.social.service.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AuthenticateDto {
    private String email;
    private String password;
}
