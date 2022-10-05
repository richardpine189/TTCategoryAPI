package com.team8.category.Interfaces


import com.team8.models.Category

interface ICategoryRepository {
    fun getCategories(amountCategories:Int?) : Array<Category>

    fun getCategoryNames(amountCategories:Int?) : Array<String>
    fun getCategoryByName(name: String): Category
}