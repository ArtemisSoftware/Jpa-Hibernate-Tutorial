package com.artemissoftware.jpa_hibernate_tutorial.jpa

import com.artemissoftware.jpa_hibernate_tutorial.Course
import com.artemissoftware.jpa_hibernate_tutorial.jdbc.CourseJdbcRepository.Companion.SELECT_QUERY_ARGUMENTS
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
@Transactional
class CourseJpaRepository {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    fun insert(course: Course){
        entityManager.merge(course)
    }

    fun findById(id: Long): Course? {
        return entityManager.find(Course::class.java, id)
    }

    fun deleteById(id: Long) {
        val course = entityManager.find(Course::class.java, id)
        entityManager.remove(course)
    }
}