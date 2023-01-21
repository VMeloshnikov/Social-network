package Entity;

import Entity.CompositeKey.UserRolesPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@IdClass(UserRolesPK.class)
public class UserRoles implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role roleId;

}
