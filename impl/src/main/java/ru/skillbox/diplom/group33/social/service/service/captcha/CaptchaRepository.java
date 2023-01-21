package ru.skillbox.diplom.group33.social.service.service.captcha;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skillbox.diplom.group33.social.service.Captcha;

import java.util.UUID;

@Repository
public interface CaptchaRepository extends CrudRepository<Captcha, UUID> {

}
