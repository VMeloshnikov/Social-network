package ru.skillbox.diplom.group33.social.service.dto;

import lombok.Data;

@Data
public class CaptchaDto {

    private String secret;
    private String image;

}
