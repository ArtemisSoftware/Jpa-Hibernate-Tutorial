package com.artemissoftware.jpa_hibernate_tutorial

import com.artemissoftware.jpa_hibernate_tutorial.jdbc.CourseJdbcRepository
import com.artemissoftware.jpa_hibernate_tutorial.jpa.CourseJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CourseCommandLineRunner : CommandLineRunner {

    @Autowired
    private lateinit var repositoryJdbc: CourseJdbcRepository

    @Autowired
    private lateinit var repositoryJpa: CourseJpaRepository

    override fun run(vararg args: String?) {
        jpa()
    }

    private fun jdbc() = with(repositoryJdbc){
        insert(Course(1, "The signs", "Gold era"))
        insert(Course(2, "The constellation", "Andromeda"))
        deleteById(1)
        println(findById(2))
    }

    private fun jpa() = with(repositoryJpa){
        insert(Course(1, "The Gold saints", "Gold era"))
        insert(Course(2, "The Silver saints", "Andromeda"))
        deleteById(1)
        println(findById(2))
    }
}