package com.team8.useCases.getCategoriesUseCase


import com.team8.category.Interfaces.IGetCategories
import com.team8.category.Interfaces.ICategoryRepository
import com.team8.models.Category

class GetCategoriesUseCase(var categoryRepository: ICategoryRepository) : IGetCategories {

    override suspend fun GetCategories(amountCategories: Int?): Array<String> {
        var tempCategories = categoryRepository.getCategoryNames(amountCategories)
        return tempCategories
    }

    override suspend fun GetCategoryByName(name: String): Category? {
        return try {
            categoryRepository.getCategoryByName(name)
        } catch(ex : NoSuchElementException) {
            null
        }
    }
}