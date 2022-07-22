package com.team8.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }

    install(Resources)

    /*routing {
    }*/
}
