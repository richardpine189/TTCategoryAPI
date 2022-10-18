package com.team8.categoryTest

import com.team8.useCases.getCategoriesUseCase.GetCategoriesUseCase
import com.team8.category.Interfaces.ICategoryRepository
import com.team8.models.Category
import io.mockk.coEvery
import io.mockk.mockk

import junit.framework.TestCase.*
import kotlinx.coroutines.test.runTest
import org.junit.BeforeClass
import org.junit.Test


class GetCategoriesUseCaseShould {
    companion object {

        @JvmStatic
        lateinit var getCategoriesUseCase: GetCategoriesUseCase
        @JvmStatic
        lateinit var initializeArray: Array<String>
        @JvmStatic
        lateinit var categoryArray: Array<Category>

        @BeforeClass
        @JvmStatic
        fun `Setup`() {
            initializeArray = arrayOf("Empresas", "Frutas", "Nombres", "Paises", "Famosos")
            categoryArray = arrayOf<Category>(
                Category("Marcas", arrayOf("Etermax", "Asus", "Volkswagen")),
                Category("Frutas", arrayOf("Manzana", "Banana", "Anana")),
                Category("Nombres", arrayOf("Richard", "Theo", "Paula")),
                Category("Paises", arrayOf("Argentina", "Brasil", "Canada")),
                Category("Famosos", arrayOf("Peter Dinklage", "Lionel Messi", "Donald Trump"))
            )

            val categoryRepository: ICategoryRepository = mockk()
            coEvery { categoryRepository.getCategoryNames(5) } returns initializeArray
            coEvery { categoryRepository.getCategoryNames(1) } returns initializeArray.sliceArray(0..0)
            coEvery { categoryRepository.getCategoryByName(categoryArray[0].categoryName) } returns categoryArray[0]
            getCategoriesUseCase = GetCategoriesUseCase(categoryRepository)
        }
    }
    @Test
    fun `Given a request return five categories objects`() = runTest {
        assertEquals(initializeArray, getCategoriesUseCase.GetCategories(5))
    }

    @Test
    fun `Given a request return one category object`() = runTest {
        assertTrue(initializeArray.contains(getCategoriesUseCase.GetCategories(1)[0]))
    }

    @Test
    fun `Check the return array's size`() = runTest {
        assertEquals(1, getCategoriesUseCase.GetCategories(1).size)
    }

    @Test
    fun `Get category by name`() = runTest {
        val expectedCategory = categoryArray[0]

        // Act
        val result = getCategoriesUseCase.GetCategoryByName(expectedCategory.categoryName)

        // Assert
        assertEquals(expectedCategory, result)
    }
}