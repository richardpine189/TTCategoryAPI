package com.team8.repositories

import com.team8.Interfaces.ICategoryRepository
import com.team8.models.Category
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class JsonCategoryRepository(val filePath: String) : ICategoryRepository  {
    override fun GetCategories(amountCategories: Int): Array<String> {
        var jsonString = File(filePath).readText(Charsets.UTF_8)
        val categoryArray = Json.decodeFromString<Array<Category>>(jsonString)
        return categoryArray.map { it.categoryName }.toTypedArray()
    }
}
