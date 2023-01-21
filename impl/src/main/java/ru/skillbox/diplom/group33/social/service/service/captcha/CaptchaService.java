package ru.skillbox.diplom.group33.social.service.service.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skillbox.diplom.group33.social.service.Captcha;
import ru.skillbox.diplom.group33.social.service.dto.CaptchaDto;
import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;


@Service
public class CaptchaService {

    private CaptchaRepository captchaRepository;


    @Autowired
    public CaptchaService(CaptchaRepository captchaRepository) {
        this.captchaRepository = captchaRepository;
    }

    public CaptchaDto getCaptcha() {
        return null;
    }

    public Captcha createCaptcha() {
        return new CaptchaBuilder()
                .createImage(121, 45)
                .build();
    }

    public boolean passCaptcha(RegistrationDto registrationDto) {
        // Captcha captcha = captchaRepository.findById(не знаю откуда взять UUID);
        Captcha captcha = new Captcha();
        return registrationDto.getCaptchaDto().getSecret().equals(captcha.getSecret());

    }

}
