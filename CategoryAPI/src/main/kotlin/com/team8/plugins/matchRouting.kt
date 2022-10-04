package com.team8.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.http.*

fun Application.matchRouting() {
    routing{
        route("/Match"){
            post(){

            }

        }
    }
}