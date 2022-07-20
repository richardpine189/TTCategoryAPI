package com.team8.plugins

import com.team8.Interfaces.ICategoryRepository
import com.team8.actions.CategoryAction
import com.team8.models.Category
import com.team8.repositories.JsonCategoryRepository
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import java.util.Arrays

val listCat = listOf<Category>(
    Category("Animales", arrayOf("Araña", "Oso")),
    Category("Paises", arrayOf("Argentina", "Brasil"))
)

val repository : ICategoryRepository = JsonCategoryRepository()

fun Application.configureRouting() {
    routing {
        route("/Categories"){
            get{
                call.respond(listCat)
            }

            get("/{amountCategories}"){
                val amount = call.parameters["amountCategories"]?.toIntOrNull()

                val action : CategoryAction = CategoryAction(repository)

                val result = when(amount)
                {
                    null -> call.respond(HttpStatusCode.BadRequest, "Must pass amount")
                    else -> { action.GetCategories(amount).toList() }
                }

                call.respond(result)
            }

            get("/{name}"){

            }

        }

    }
}
