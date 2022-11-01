package com.team8.plugins

import com.team8.useCases.getCategoriesUseCase.GetCategoriesUseCase
import com.team8.category.Interfaces.IGetCategories
import com.team8.category.Interfaces.ICategoryRepository
import com.team8.category.repositories.FirebaseCategoryRepository
import com.team8.useCases.getCorrection.GetCorrectionUseCase
import com.team8.category.repositories.JsonCategoryRepository
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*


//val repository : ICategoryRepository = JsonCategoryRepository("./src/main/kotlin/com/team8/DataBase/Categories.json")
val repository : ICategoryRepository = FirebaseCategoryRepository("https://topic-twister-categories-default-rtdb.firebaseio.com")

fun Application.configureRouting() {
    routing {
        route("/Categories"){
            get{
                val action = GetCategoriesUseCase(repository)
                val result = action.GetCategories().toList()
                call.respond(result)
            }

            get("/{amountCategories}"){
                val amount = call.parameters["amountCategories"]?.toIntOrNull()

                val action = GetCategoriesUseCase(repository)

                val result = when(amount)
                {
                    null -> call.respond(HttpStatusCode.BadRequest, "Must pass amount")
                    else -> { action.GetCategories(amount).toList() }
                }

                call.respond(result)
            }

        }

        get("/isValid")
        {
            val numberOfCorrections = 5

            var words = arrayOfNulls<String>(numberOfCorrections)

            for (i in 0 until numberOfCorrections)
            {
                words[i] = call.request.queryParameters["word[$i]"]
            }

            var categories = arrayOfNulls<String>(numberOfCorrections)

            for (i in 0 until numberOfCorrections)
            {
                categories[i] = call.request.queryParameters["category[$i]"]
            }

            val letter = call.request.queryParameters["letter"]


            if(words.any{it == null})
            {
                call.respond(HttpStatusCode.BadRequest, "Must send a word")
            }
            else
            {
                if(categories.any{it == null})
                {
                    call.respond(HttpStatusCode.BadRequest, "Must send a category")
                }
                else
                {
                    if(categories.any{ !it!![0].isLetter() })
                    {
                        call.respond(HttpStatusCode.BadRequest, "Category must start with letter")
                    }
                    else {
                        val getCategoriesUseCase: IGetCategories = GetCategoriesUseCase(repository)

                        val action = GetCorrectionUseCase(getCategoriesUseCase)

                        var results = arrayOfNulls<Boolean>(numberOfCorrections)

                        for (i in 0 until numberOfCorrections){
                            results[i] = action.isValid(words[i]!!, categories[i]!!,letter!![0])
                        }

                        call.respond(results)
                    }
                }
            }
        }
    }
}
