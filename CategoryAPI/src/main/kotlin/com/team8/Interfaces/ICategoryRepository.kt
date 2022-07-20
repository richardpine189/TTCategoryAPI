package com.team8.Interfaces

import com.team8.models.Category

interface ICategoryRepository {
    fun GetCategories(amountCategories:Int) : Array<Category>

    fun GetCategoryNames(amountCategories:Int) : Array<String>
}