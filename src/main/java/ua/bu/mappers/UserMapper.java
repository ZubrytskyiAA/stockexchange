package ua.bu.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.bu.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
       User user = new User();
       user.setId(resultSet.getInt("id"));
       user.setLoginName(resultSet.getString("loginname"));
       user.setPassword(resultSet.getString("password"));
       user.setFio(resultSet.getString("fio"));
       user.setEmail(resultSet.getString("email"));
       user.setPhoneNumber(resultSet.getString("phonenumber"));
        return user;
    }
}
