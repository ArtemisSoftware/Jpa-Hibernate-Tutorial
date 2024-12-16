package com.artemissoftware.jpa_hibernate_tutorial.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CourseJdbcCommandLineRunner : CommandLineRunner {

    @Autowired
    private lateinit var repository: CourseJdbcRepository

    override fun run(vararg args: String?) {
        repository.insert()
    }
}