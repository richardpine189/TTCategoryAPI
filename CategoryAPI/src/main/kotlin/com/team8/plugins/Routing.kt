package com.team8.plugins

import com.team8.Interfaces.ICategoryGetter
import com.team8.Interfaces.ICategoryRepository
import com.team8.actions.CategoryAction
import com.team8.actions.CorrectionAction
import com.team8.models.Category
import com.team8.repositories.JsonCategoryRepository
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import java.util.Arrays

val repository : ICategoryRepository = JsonCategoryRepository("./src/main/kotlin/com/team8/DataBase/Categories.json")

fun Application.configureRouting() {
    routing {
        route("/Categories"){
            get{
                val action : CategoryAction = CategoryAction(repository)
                val result = action.GetCategories().toList()
                call.respond(result)
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

        get("/isValid")
        {
            val word = call.request.queryParameters["word"]
            val categoryString = call.request.queryParameters["category"]

            if(word.isNullOrEmpty())
            {
                call.respond(HttpStatusCode.BadRequest, "Must send a word")
            }
            else
            {
                if(categoryString.isNullOrEmpty())
                {
                    call.respond(HttpStatusCode.BadRequest, "Must send a category")
                }
                else
                {
                    if(!categoryString[0].isLetter())
                    {
                        call.respond(HttpStatusCode.BadRequest, "Category must start with letter")
                    }
                    else {
                        val categoryAction: ICategoryGetter = CategoryAction(repository)

                        val action = CorrectionAction(categoryAction);

                        val result = action.isValid(word, categoryString)

                        call.respond(result)
                    }
                }
            }
        }
    }
}
