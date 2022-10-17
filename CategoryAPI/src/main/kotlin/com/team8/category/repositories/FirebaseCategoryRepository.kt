package com.team8.category.repositories

import com.team8.category.Interfaces.ICategoryRepository
import com.team8.models.Category
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class FirebaseCategoryRepository(val repositoryPath : String) : ICategoryRepository {
    suspend fun getAllCategories() : Array<Category> {
        val client = HttpClient()

        var response : HttpResponse = client.get("$repositoryPath/Categorias.json")

        if(response.status == HttpStatusCode.NotFound)
        {
            throw Exception("Match database not available.")
        }

        if(response.bodyAsText() == "null")
        {
            return emptyArray()
        }

        TODO("Not yet implemented")
    }

    override suspend fun getCategories(amountCategories: Int?): Array<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryNames(amountCategories: Int?): Array<String> {
        val client = HttpClient()

        var response : HttpResponse = client.get("$repositoryPath/nombresCategorias.json")

        if(response.status == HttpStatusCode.NotFound)
        {
            throw Exception("Match database not available.")
        }

        if(response.bodyAsText() == "null")
        {
            return emptyArray()
        }

        val categoryArray = Json.decodeFromString<Array<String>>(response.body())

        return categoryArray
    }

    override suspend fun getCategoryByName(name: String): Category {
        TODO("Not yet implemented")
    }
}