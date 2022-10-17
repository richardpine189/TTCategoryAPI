package com.team8.categoryTest

import com.team8.category.Interfaces.IGetCategories
import com.team8.useCases.getCorrection.GetCorrectionUseCase
import com.team8.models.Category
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GetCorrectionUseCaseShould {

//    @Test
//    fun `Return true if word is in category`()
//    {
//        // Arrange
//        val word = "Argentina"
//        val categoryString = "Paises"
//        val categoryAction : IGetCategories = mock()
//        whenever(categoryAction.GetCategoryByName("Paises")).thenReturn(Category("Paises", arrayOf("Argentina", "Brasil", "Chile")))
//        val action = GetCorrectionUseCase(categoryAction)
//
//        // Act
//        val result = action.isValid(word, categoryString, letter = 'a')
//
//        // Assert
//        assertTrue { result }
//    }
//
//    @Test
//    fun `Return false if word isn't in category`()
//    {
//        // Arrange
//        val word = "China"
//        val categoryString = "Paises"
//        val categoryAction : IGetCategories = mock()
//        whenever(categoryAction.GetCategoryByName("Paises")).thenReturn(Category("Paises", arrayOf("Argentina", "Brasil", "Chile")))
//        val action : GetCorrectionUseCase = GetCorrectionUseCase(categoryAction)
//
//        // Act
//        val result = action.isValid(word, categoryString, letter = 'c')
//
//        // Assert
//        assertFalse { result }
//    }
}