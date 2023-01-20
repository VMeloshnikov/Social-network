package ru.skillbox.diplom.group33.social.service.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skillbox.diplom.group33.social.service.model.User;
import ru.skillbox.diplom.group33.social.service.security.jwt.JwtUser;
import ru.skillbox.diplom.group33.social.service.security.jwt.JwtUserFactory;
import ru.skillbox.diplom.group33.social.service.service.UserService;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {


    private final UserService service;

    public JwtUserDetailsService(UserService service) {
        this.service = service;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = service.findUserByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with name: " + username + " not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("User {} loaded", username);
        return jwtUser;
    }
}
