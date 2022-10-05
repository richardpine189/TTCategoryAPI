package com.team8.category.Interfaces

import com.team8.models.Category

interface IGetCategories{
    fun GetCategories(amountCategories : Int? = null) : Array<String>

    fun GetCategoryByName(name : String) : Category?
}