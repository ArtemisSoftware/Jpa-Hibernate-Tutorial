package com.artemissoftware.jpa_hibernate_tutorial.jdbc

import com.artemissoftware.jpa_hibernate_tutorial.Course
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CourseJdbcCommandLineRunner : CommandLineRunner {

    @Autowired
    private lateinit var repository: CourseJdbcRepository

    override fun run(vararg args: String?) {
        //repository.insert()
        repository.insert(Course(1, "The signs", "Gold era"))
        repository.insert(Course(2, "The constellation", "Andromeda"))
        repository.deleteById(1)
        System.out.println(repository.findById(2))
    }
}