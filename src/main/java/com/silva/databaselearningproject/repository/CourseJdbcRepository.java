package com.silva.databaselearningproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String INSERT_QUERY= """ 
            insert into course (id, name, author)
            values(1, 'Learn Database', 'me as author');
            """;

    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }

}
