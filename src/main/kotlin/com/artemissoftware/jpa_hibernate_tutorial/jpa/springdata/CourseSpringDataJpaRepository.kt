package com.artemissoftware.jpa_hibernate_tutorial.jpa.springdata

import com.artemissoftware.jpa_hibernate_tutorial.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseSpringDataJpaRepository: JpaRepository<Course, Long> {

    fun findByAuthor(author: String): List<Course>
}