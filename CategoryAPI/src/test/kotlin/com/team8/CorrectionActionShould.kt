package com.team8

import com.team8.Interfaces.ICategoryGetter
import com.team8.actions.CategoryAction
import com.team8.actions.CorrectionAction
import com.team8.models.Category
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CorrectionActionShould {

    @Test
    fun `Return true if word is in category`()
    {
        // Arrange
        val word = "Argentina"
        val categoryString = "Paises"
        val categoryAction : ICategoryGetter = mock()
        whenever(categoryAction.GetCategoryByName("Paises")).thenReturn(Category("Paises", arrayOf("Argentina", "Brasil", "Chile")))
        val action : CorrectionAction = CorrectionAction(categoryAction)

        // Act
        val result = action.isValid(word, categoryString)

        // Assert
        assertTrue { result }
    }

    @Test
    fun `Return false if word isn't in category`()
    {
        // Arrange
        val word = "China"
        val categoryString = "Paises"
        val categoryAction : ICategoryGetter = mock()
        whenever(categoryAction.GetCategoryByName("Paises")).thenReturn(Category("Paises", arrayOf("Argentina", "Brasil", "Chile")))
        val action : CorrectionAction = CorrectionAction(categoryAction)

        // Act
        val result = action.isValid(word, categoryString)

        // Assert
        assertFalse { result }
    }
}