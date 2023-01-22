package ru.skillbox.diplom.group33.social.service.repository;
import ru.skillbox.diplom.group33.social.service.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
