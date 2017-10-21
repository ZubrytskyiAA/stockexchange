package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.Role;

@Component
public interface RoleDao {


    void save(Role role);
    Role updateUser(Role role);
    Role getById(long id);
    void deleteById(long id);

}
