package com.artemissoftware.jpa_hibernate_tutorial.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CourseJdbcRepository {

    @Autowired
    private lateinit var springJdbcTemplate: JdbcTemplate

    fun insert(){
        springJdbcTemplate.update(INSERT_QUERY)
    }

    companion object {
        const val INSERT_QUERY =
            """
                insert into course (id, name, author) values (1, 'Learn astrology', 'Yoga');
            """
    }
}