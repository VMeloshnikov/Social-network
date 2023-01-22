package ru.skillbox.diplom.group33.social.service.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skillbox.diplom.group33.social.service.config.security.jwt.JwtTokenProvider;
import ru.skillbox.diplom.group33.social.service.dto.AuthenticateDto;
import ru.skillbox.diplom.group33.social.service.dto.AuthenticateResponseDto;
import ru.skillbox.diplom.group33.social.service.dto.RegistrationDto;
import ru.skillbox.diplom.group33.social.service.dto.UserDto;
import ru.skillbox.diplom.group33.social.service.mapper.SimpleMapper;
import ru.skillbox.diplom.group33.social.service.model.Role;
import ru.skillbox.diplom.group33.social.service.model.User;
import ru.skillbox.diplom.group33.social.service.repository.RoleRepository;
import ru.skillbox.diplom.group33.social.service.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    public AuthService(
            JwtTokenProvider jwtTokenProvider,
            UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder encoder) {
        this.jwtTokenProvider = jwtTokenProvider;

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }


    public AuthenticateResponseDto login(@NonNull AuthenticateDto authenticateDto) {
        try {
            final User user = userRepository.findByEmail(authenticateDto.getEmail());
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            if (user.getPassword().equals(encoder.encode(authenticateDto.getPassword()))) {
                String token = jwtTokenProvider.createAccessToken(user);
                String refreshToken = jwtTokenProvider.createRefreshToken(user);
                return new AuthenticateResponseDto(token, refreshToken);
            } else {
                throw new BadCredentialsException("Invalid email or password");
            }
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email or password");
        }
    }

    public UserDto register(RegistrationDto registrationDto) {
        User checkUser = userRepository.findByEmail(registrationDto.getEmail());
        if (checkUser != null) {
            log.warn("User already exists");
            return null;
        }

        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("USER");
        roles.add(role);

        User registeredUser = SimpleMapper.INSTANCE.sourceRegToUser(registrationDto);
        registeredUser.setRoles(roles);

        userRepository.save(registeredUser);

        UserDto userDto = SimpleMapper.INSTANCE.sourceToUserDto(registrationDto);

        return userDto;
    }

    public UserDto createUser(UserDto userDto) {

        User checkUser = userRepository.findByEmail(userDto.getEmail());
        if (checkUser != null) {
            log.warn("User already exists");
            return null;
        }

        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("MODERATOR");
        roles.add(role);

        RegistrationDto user = SimpleMapper.INSTANCE.sourceToRegistrationDto(userDto);
        User userToSave = SimpleMapper.INSTANCE.sourceRegToUser(user);
        userToSave.setRoles(roles);
        userRepository.save(userToSave);

        return userDto;
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        log.info("Find - {} users", users.size());
        return users;
    }

    public User findUserByName(String name) {
        User result = userRepository.findByUserName(name);
        log.info("User {} find by name {}", result, name);
        return result;
    }

    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            log.warn("No such user");
            return null;
        }
        log.info("User {} find by id {}", user, id);
        return user;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
