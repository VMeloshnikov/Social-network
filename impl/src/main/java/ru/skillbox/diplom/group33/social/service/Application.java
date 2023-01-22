package ru.skillbox.diplom.group33.social.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;
import ru.skillbox.diplom.group33.social.service.dto.UserDto;
import ru.skillbox.diplom.group33.social.service.mapper.SimpleMapper;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
