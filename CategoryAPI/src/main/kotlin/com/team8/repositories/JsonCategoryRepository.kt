package com.team8.repositories

import com.team8.Interfaces.ICategoryRepository
import com.team8.models.Category
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class JsonCategoryRepository(private val filePath: String = "./src/test/testCategories.json") : ICategoryRepository  {
    override fun GetCategories(amountCategories: Int): Array<Category> {
        val jsonString = File(filePath).readText(Charsets.UTF_8)
        var categoryArray = Json.decodeFromString<Array<Category>>(jsonString)
        categoryArray = categoryArray.sliceArray(0 until amountCategories)
        return categoryArray
    }

    override fun GetCategoryNames(amountCategories: Int): Array<String> {
        val jsonString = File(filePath).readText(Charsets.UTF_8)
        var categoryArray = Json.decodeFromString<Array<Category>>(jsonString)
        categoryArray = categoryArray.sliceArray(0 until amountCategories)
        return categoryArray.map { it.categoryName }.toTypedArray()
    }
}
