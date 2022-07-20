package com.team8.actions

import com.team8.Interfaces.ICategoryRepository

class CategoryAction(var categoryRepository: ICategoryRepository) {

    fun GetCategories(amountCategories: Int): Array<String> {
        var tempCategories = categoryRepository.GetCategoryNames(amountCategories)
        return tempCategories
    }
}