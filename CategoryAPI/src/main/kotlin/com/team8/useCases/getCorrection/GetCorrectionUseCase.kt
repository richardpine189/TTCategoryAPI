package com.team8.useCases.getCorrection

import com.team8.category.Interfaces.IGetCategories

class GetCorrectionUseCase(val getCategories: IGetCategories) {
    fun isValid(word: String, categoryString: String, letter: Char): Boolean {
        var category = getCategories.GetCategoryByName(categoryString)
        if(category == null)
        {
            return false
        }
        return category.validWord(word, letter)
    }
}
