package com.team8.repositories

import com.team8.Interfaces.ICategoryRepository
import com.team8.models.Category
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class JsonCategoryRepository(private val filePath: String = "./src/test/testCategories.json") : ICategoryRepository  {

    fun GetAllCategories() : Array<Category> {
        val jsonString = File(filePath).readText(Charsets.UTF_8)
        return Json.decodeFromString(jsonString)
    }

    override fun GetCategories(amountCategories: Int?): Array<Category> {
        var categoryArray = GetAllCategories()

        amountCategories?.let {
            categoryArray = categoryArray.sliceArray(0 until amountCategories)
        }

        return categoryArray
    }

    override fun GetCategoryNames(amountCategories: Int?): Array<String> {
        val categoryArray = GetCategories(amountCategories)

        return categoryArray.map { it.categoryName }.toTypedArray()
    }

    override fun GetCategoryByName(name: String): Category {
        val categories = GetAllCategories()
        return categories.first{it.categoryName == name}
    }
}
