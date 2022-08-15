package com.example.plugins

import com.example.controllers.UserController
import com.example.dto.UserDTO
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    val userController = UserController()

    routing {
        route("users") {
            get("/all") {
                call.respond(userController.findAll())
            }
            post("/new") {
                val newUser = call.receive<UserDTO>()
                userController.insert(newUser)
                call.respond(HttpStatusCode.Created)
            }
        }
        route("/") {
            get {
                call.respondText("Hello World!")
            }
        }
    }
}
