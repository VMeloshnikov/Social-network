package Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Role", schema = "jwt")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, unique = true)
    private long roleId;
    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;
    @OneToMany(mappedBy = "roleId")
    private Set<UserRoles> userRoles;

}
