package com.team8.actions

import com.team8.Interfaces.ICategoryGetter
import com.team8.Interfaces.ICategoryRepository
import com.team8.models.Category

class CategoryAction(var categoryRepository: ICategoryRepository) : ICategoryGetter {

    override fun GetCategories(amountCategories: Int?): Array<String> {
        var tempCategories = categoryRepository.GetCategoryNames(amountCategories)
        return tempCategories
    }

    override fun GetCategoryByName(name: String): Category? {
        return try {
            categoryRepository.GetCategoryByName(name)
        } catch(ex : NoSuchElementException) {
            null
        }
    }
}