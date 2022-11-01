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
import java.util.*

class FirebaseCategoryRepository(val repositoryPath : String) : ICategoryRepository {
    suspend fun getAllCategories() : Array<Category> {
        val client = HttpClient()

        var response : HttpResponse = client.get("$repositoryPath/Categorias.json")

        if(response.status == HttpStatusCode.NotFound)
        {
            throw Exception("Categories database not available.")
        }

        if(response.bodyAsText() == "null")
        {
            return emptyArray()
        }

        val categoriesMap = Json.decodeFromString<Map<String, Array<String>>>(response.body())

        val categoriesArray = MapToCategories(categoriesMap)

        return categoriesArray
    }

    override suspend fun getCategories(amountCategories: Int?): Array<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryNames(amountCategories: Int?): Array<String> {
        val client = HttpClient()

        var response : HttpResponse = client.get("$repositoryPath/nombresCategorias.json")

        if(response.status == HttpStatusCode.NotFound)
        {
            throw Exception("Categories database not available.")
        }

        if(response.bodyAsText() == "null")
        {
            return emptyArray()
        }

        var categoryArray = Json.decodeFromString<Array<String>>(response.body())
        categoryArray.shuffle()
        amountCategories?.let {
            categoryArray = categoryArray.sliceArray(0 until amountCategories)
        }

        return categoryArray
    }

    override suspend fun getCategoryByName(name: String): Category {
        val client = HttpClient()

        var response : HttpResponse = client.get("$repositoryPath/Categorias/${name}.json")

        if(response.status == HttpStatusCode.NotFound)
        {
            throw Exception("Categories database not available.")
        }

        if(response.bodyAsText() == "null")
        {
            throw Exception("The requested category has not been found.")
        }

        val words = Json.decodeFromString<Array<String>>(response.body())

        return Category(name, words)
    }

    private fun MapToCategories(map: Map<String, Array<String>>): Array<Category> {
        var categoryArray : MutableList<Category> = mutableListOf<Category>()

        for (category in map)
        {
            categoryArray.add(Category(category.key, category.value))
        }

        return categoryArray.toTypedArray()
    }
}