package ru.skillbox.diplom.group33.social.service.model;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String e_mail;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public User(String username, String e_mail, String password, List<Role> roles) {
        this.username = username;
        this.e_mail = e_mail;
        this.password = password;
        this.roles = roles;
    }
}





