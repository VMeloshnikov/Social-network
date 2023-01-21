package Entity.CompositeKey;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@AllArgsConstructor
@EqualsAndHashCode
public class UserRolesPK implements Serializable {

    private long userId;
    private long roleId;
}
