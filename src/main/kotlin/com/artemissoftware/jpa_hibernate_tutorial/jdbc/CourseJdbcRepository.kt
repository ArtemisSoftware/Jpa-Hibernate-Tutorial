package com.artemissoftware.jpa_hibernate_tutorial.jdbc

import com.artemissoftware.jpa_hibernate_tutorial.Course
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CourseJdbcRepository {

    @Autowired
    private lateinit var springJdbcTemplate: JdbcTemplate

    fun insert(){
        springJdbcTemplate.update(INSERT_QUERY)
    }

    fun insert(course: Course) = with(course){
        springJdbcTemplate.update(INSERT_QUERY_ARGUMENTS, id, name, author)
    }

    fun deleteById(id: Int){
        springJdbcTemplate.update(DELETE_QUERY_ARGUMENTS, id)
    }

    fun findById(id: Long): Course? {
        return springJdbcTemplate.queryForObject(
            SELECT_QUERY_ARGUMENTS,
            BeanPropertyRowMapper(Course::class.java),
            id
        )
    }

    companion object {
        const val INSERT_QUERY =
            """
                insert into course (id, name, author) values (1, 'Learn astrology', 'Yoga');
            """
        const val INSERT_QUERY_ARGUMENTS =
            """
                insert into course (id, name, author) values (?, ?, ?);
            """

        const val DELETE_QUERY_ARGUMENTS =
            """
                delete from course where id = ?;
            """

        const val SELECT_QUERY_ARGUMENTS =
            """
                SELECT * FROM course where id = ?;
            """
    }
}