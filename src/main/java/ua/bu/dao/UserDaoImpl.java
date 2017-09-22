package ua.bu.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ua.bu.entity.User;
import ua.bu.mappers.UserMapper;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
