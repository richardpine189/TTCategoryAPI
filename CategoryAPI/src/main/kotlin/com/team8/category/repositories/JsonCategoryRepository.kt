package com.team8.category.repositories

import com.team8.category.Interfaces.ICategoryRepository
import com.team8.models.Category
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class JsonCategoryRepository(private val filePath: String = "./src/test/testCategories.json") : ICategoryRepository {

    fun getAllCategories() : Array<Category> {
        val jsonString = File(filePath).readText(Charsets.UTF_8)
        return Json.decodeFromString(jsonString)
    }

    override fun getCategories(amountCategories: Int?): Array<Category> {
        var categoryArray = getAllCategories()
        categoryArray.shuffle()

        amountCategories?.let {
            categoryArray = categoryArray.sliceArray(0 until amountCategories)
        }

        return categoryArray
    }

    override fun getCategoryNames(amountCategories: Int?): Array<String> {
        val categoryArray = getCategories(amountCategories)

        return categoryArray.map { it.categoryName }.toTypedArray()
    }

    override fun getCategoryByName(name: String): Category {
        val categories = getAllCategories()
        return categories.first{it.categoryName == name}
    }
}
