package com.team8.category.Interfaces

import com.team8.models.Category

interface IGetCategories{
    suspend fun GetCategories(amountCategories : Int? = null) : Array<String>

    suspend fun GetCategoryByName(name : String) : Category?
}