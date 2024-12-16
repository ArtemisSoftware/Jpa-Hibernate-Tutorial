package com.artemissoftware.jpa_hibernate_tutorial

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Course(
    @Id
    var id: Long = 0,
    @Column(name = "name")
    var name: String = "",
    @Column(name = "author")
    var author: String = ""
)