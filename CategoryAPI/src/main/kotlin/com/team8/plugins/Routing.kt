package com.team8.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@kotlinx.serialization.Serializable
data class prueba(val nameCat : String)

val listCat = listOf<prueba>( prueba("Animales"), prueba("Paises"))
fun Application.configureRouting() {
    routing {
        route("/Categories"){
            get{
                val newResponde = Json.encodeToString(listCat[0])
                call.respond(newResponde)
            }
            get("/{amountCategories}"){
            val amount = call.parameters["amountCategories"]?.toIntOrNull()

            }
            get("/{name}"){

            }

        }

    }
}
