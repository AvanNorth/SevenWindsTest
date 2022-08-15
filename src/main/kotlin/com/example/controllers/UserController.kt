package com.example.controllers

import com.example.dto.User
import com.example.dto.UserDTO
import com.example.dto.Users
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

class UserController {
    fun findAll(): ArrayList<User> {
        val users: ArrayList<User> = arrayListOf()

        transaction {
            Users.selectAll().map { row ->
                users.add(
                    User(
                        id = row[Users.id],
                        email = row[Users.email],
                        firstName = row[Users.firstName],
                        lastName = row[Users.lastName],
                        middleName = row[Users.middleName],
                        phoneNumber = row[Users.phoneNumber]
                    )
                )
            }
        }
        return users
    }

    fun insert(user: UserDTO) {
        transaction {
            Users.insert {
                it[id] = UUID.randomUUID()
                it[email] = user.email
                it[firstName] = user.firstName
                it[lastName] = user.lastName
                it[middleName] = user.middleName
                it[phoneNumber] = user.phoneNumber
            }
        }
    }
}