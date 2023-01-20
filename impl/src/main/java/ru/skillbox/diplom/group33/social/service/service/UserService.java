package ru.skillbox.diplom.group33.social.service.service;

import ru.skillbox.diplom.group33.social.service.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findUserByName(String name);

    User findById(Long id);

    void delete(Long id);
}
