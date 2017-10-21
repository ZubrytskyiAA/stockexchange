package ua.bu.dao.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.bu.entity.User;

@Repository
public interface UserDao2 extends JpaRepository<User, Long> {

    User findById(long id);

    User findByLoginName(String loginName);

    @Override
    Page<User> findAll(Pageable pageable);


}
