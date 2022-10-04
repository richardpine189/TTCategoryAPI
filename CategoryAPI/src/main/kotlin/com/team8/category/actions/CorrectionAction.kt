package com.team8.category.actions

import com.team8.category.Interfaces.ICategoryGetter

class CorrectionAction(val CategoryAction: ICategoryGetter) {
    fun isValid(word: String, categoryString: String, letter: Char): Boolean {
        var category = CategoryAction.GetCategoryByName(categoryString)
        if(category == null)
        {
            return false
        }
        return category.validWord(word, letter)
    }
}
