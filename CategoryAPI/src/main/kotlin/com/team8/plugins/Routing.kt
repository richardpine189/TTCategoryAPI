package com.team8.plugins

import com.team8.models.Category
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

val listCat = listOf<Category>( Category("Animales", arrayOf("Araña", "Oso")), Category("Paises", arrayOf("Argentina", "Brasil")))

fun Application.configureRouting() {
    routing {
        route("/Categories"){
            get{
                call.respond(listCat)
            }

            get("/{amountCategories}"){
            val amount = call.parameters["amountCategories"]?.toIntOrNull()

            }

            get("/{name}"){

            }

        }

    }
}
