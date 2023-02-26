package com.Secure.Marshmallow;

import org.apache.catalina.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BoardRepository {
    private JdbcTemplate jdbcTemplate;
    public Board writePost(String title, String writer, String content, String password) {
        String query = "INSERT INTO Board(title,writer,content,password) VALUES('" + title + "','" + writer + "','" + content + "','" + password + "')";
        return (Board) jdbcTemplate.queryForObject(query, new Object[]{title, writer,content,password}, new BeanPropertyRowMapper<>(User.class));
    }

    public Board viewPost(int idx) {
        String query = "SELECT * FROM Board where idx='" + idx + "'";
        return (Board) jdbcTemplate.queryForObject(query, new Object[]{idx}, new BeanPropertyRowMapper<>(User.class));
    }

}
