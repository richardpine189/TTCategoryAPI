package com.team8.actions

import com.team8.Interfaces.ICategoryGetter

class CorrectionAction(val CategoryAction: ICategoryGetter) {
    fun isValid(word: String, categoryString: String): Boolean {
        var category = CategoryAction.GetCategoryByName(categoryString)
        if(category == null)
        {
            return false
        }
        return category.ValidWord(word)
    }
}
