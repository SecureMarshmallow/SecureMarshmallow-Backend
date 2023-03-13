package com.Secure.Marshmallow;

import org.apache.catalina.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public User Login(String username, String password) {
        String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        return jdbcTemplate.queryForObject(query, new Object[]{username, password}, new BeanPropertyRowMapper<>(User.class));
        //String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        //return jdbcTemplate.queryForObject(query, new Object[]{username, password}, new BeanPropertyRowMapper<>(User.class));

    }

    public User Register(String username, String password, String id, String gmail) {
        String query = "INSERT INTO user(id,username,password,gmail) VALUES('"+ id +"','"+ username + "','" + password + "','" + gmail + "')";
        return jdbcTemplate.queryForObject(query, new Object[]{username, password, id, gmail}, new BeanPropertyRowMapper<>(User.class));
        //String query = "INSERT INTO user(id,username,password,gmail) VALUES(?,?,?,?)";
        //jdbcTemplate.update(query, new Object[]{id, username, password, gmail});

    }

    // 코드들 예외처리 추가 예정
}