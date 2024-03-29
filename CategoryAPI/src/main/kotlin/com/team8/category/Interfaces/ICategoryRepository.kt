package com.team8.category.Interfaces


import com.team8.models.Category

interface ICategoryRepository {
    suspend fun getCategories(amountCategories:Int?) : Array<Category>

    suspend fun getCategoryNames(amountCategories:Int?) : Array<String>

    suspend fun getCategoryByName(name: String): Category
}