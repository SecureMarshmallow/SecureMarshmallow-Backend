package com.Secure.Marshmallow;

import org.apache.catalina.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public User findByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        return jdbcTemplate.queryForObject(query, new Object[]{username, password}, new BeanPropertyRowMapper<>(User.class));
    }

    public User Register(String username, String password, String id, String gmail) {
        String query = "INSERT INTO user(id,username,password,gmail) VALUES('"+ id +"','"+ username + "','" + password + "','" + gmail + "')";
        return jdbcTemplate.queryForObject(query, new Object[]{username, password}, new BeanPropertyRowMapper<>(User.class));
    }
}