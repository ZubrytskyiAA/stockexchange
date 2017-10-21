package ua.bu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.RoleDao;
import ua.bu.entity.Role;
import ua.bu.service.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
