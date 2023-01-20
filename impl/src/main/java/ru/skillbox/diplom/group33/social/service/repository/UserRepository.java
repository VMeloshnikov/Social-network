package ru.skillbox.diplom.group33.social.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.diplom.group33.social.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
