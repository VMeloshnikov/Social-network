package ru.skillbox.diplom.group33.social.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skillbox.diplom.group33.social.service.model.Role;
import ru.skillbox.diplom.group33.social.service.model.User;
import ru.skillbox.diplom.group33.social.service.repository.TypeRepository;
import ru.skillbox.diplom.group33.social.service.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TypeRepository typeRepository;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, TypeRepository typeRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.encoder = encoder;
    }


    @Override
    public User register(User user) {
        User checkUser = userRepository.findByName(user.getUsername());
        if(checkUser != null) {
            log.warn("User already exists");
            return null;
        }

        List<Role> roles = new ArrayList<>();
        Role role = typeRepository.findByName("MODERATOR");
        roles.add(role);
        User registeredUser = User.builder()
                .name(user.getUsername())
                .e_mail(user.getE_mail())
                .password(encoder.encode(user.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        log.info("Find - {} users", users.size());
        return users;
    }

    @Override
    public User findUserByName(String name) {
        User result = userRepository.findByName(name);
        log.info("User {} find by name {}", result, name);
        return result;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            log.warn("No such user");
            return null;
        }
        log.info("User {} find by id {}", user, id);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
