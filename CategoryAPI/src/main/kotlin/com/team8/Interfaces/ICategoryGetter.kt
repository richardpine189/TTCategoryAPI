package com.team8.Interfaces

import com.team8.models.Category

interface ICategoryGetter{
    fun GetCategories(amountCategories : Int? = null) : Array<String>

    fun GetCategoryByName(name : String) : Category?
}