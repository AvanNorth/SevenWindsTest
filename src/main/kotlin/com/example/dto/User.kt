package com.example.dto

import org.jetbrains.exposed.sql.Table
import java.util.*

data class User(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val phoneNumber: String
)

data class UserDTO(
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val phoneNumber: String
)

object Users: Table() {
    val id = integer("id")
    val email = text("email")
    val firstName = text("first_name")
    val lastName = text("second_name")
    val middleName = text("middle_name")
    val phoneNumber = text("phone")
}
