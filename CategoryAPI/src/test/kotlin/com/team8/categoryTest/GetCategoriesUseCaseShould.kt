package com.team8.categoryTest

import com.team8.useCases.getCategoriesUseCase.GetCategoriesUseCase
import com.team8.category.Interfaces.ICategoryRepository
import com.team8.models.Category

import junit.framework.TestCase.*
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class GetCategoriesUseCaseShould {
//    companion object {
//
//        @JvmStatic
//        lateinit var getCategoriesUseCase: GetCategoriesUseCase
//        @JvmStatic
//        lateinit var initializeArray: Array<String>
//        @JvmStatic
//        lateinit var categoryArray: Array<Category>
//
//        @BeforeClass
//        @JvmStatic
//        fun `Setup`() {
//            initializeArray = arrayOf("Empresas", "Frutas", "Nombres", "Paises", "Famosos")
//            categoryArray = arrayOf<Category>(
//                Category("Marcas", arrayOf("Etermax", "Asus", "Volkswagen")),
//                Category("Frutas", arrayOf("Manzana", "Banana", "Anana")),
//                Category("Nombres", arrayOf("Richard", "Theo", "Paula")),
//                Category("Paises", arrayOf("Argentina", "Brasil", "Canada")),
//                Category("Famosos", arrayOf("Peter Dinklage", "Lionel Messi", "Donald Trump"))
//            )
//
//            val categoryRepository: ICategoryRepository = mock()
//            whenever(categoryRepository.getCategoryNames(5)).thenReturn(initializeArray)
//            whenever(categoryRepository.getCategoryNames(1)).thenReturn(initializeArray.sliceArray(0..0))
//            whenever(categoryRepository.getCategoryByName(categoryArray[0].categoryName)).thenReturn(categoryArray[0])
//            getCategoriesUseCase = GetCategoriesUseCase(categoryRepository)
//        }
//    }
//    @Test
//    fun `Given a request return five categories objects`()
//    {
//        assertEquals(initializeArray, getCategoriesUseCase.GetCategories(5))
//    }
//
//    @Test
//    fun `Given a request return one category object`()
//    {
//        assertTrue(initializeArray.contains(getCategoriesUseCase.GetCategories(1)[0]))
//    }
//
//    @Test
//    fun `Check the return array's size`()
//    {
//        assertEquals(1, getCategoriesUseCase.GetCategories(1).size)
//    }
//
//    @Test
//    fun `Get category by name`()
//    {
//        val expectedCategory = categoryArray[0]
//
//        // Act
//        val result = getCategoriesUseCase.GetCategoryByName(expectedCategory.categoryName)
//
//        // Assert
//        assertEquals(expectedCategory, result)
//    }
}