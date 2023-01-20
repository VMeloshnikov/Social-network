package ru.skillbox.diplom.group33.social.service.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String s) {
        super(s);
    }
}
