package com.team8
import com.team8.Interfaces.*
import com.team8.actions.CategoryAction
import com.team8.models.Category
import junit.framework.TestCase.*
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class CategoryActionShould {
    companion object {

        @JvmStatic
        lateinit var categoryAction: CategoryAction
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

            val categoryRepository: ICategoryRepository = mock()
            whenever(categoryRepository.GetCategoryNames(5)).thenReturn(initializeArray)
            whenever(categoryRepository.GetCategoryNames(1)).thenReturn(initializeArray.sliceArray(0..0))
            whenever(categoryRepository.GetCategoryByName(categoryArray[0].categoryName)).thenReturn(categoryArray[0])
            categoryAction = CategoryAction(categoryRepository)
        }
    }
    @Test
    fun `Given a request return five categories objects`()
    {
        assertEquals(initializeArray, categoryAction.GetCategories(5))
    }

    @Test
    fun `Given a request return one category object`()
    {
        assertTrue(initializeArray.contains(categoryAction.GetCategories(1)[0]))
    }

    @Test
    fun `Check the return array's size`()
    {
        assertEquals(1, categoryAction.GetCategories(1).size)
    }

    @Test
    fun `Get category by name`()
    {
        val expectedCategory = categoryArray[0]

        // Act
        val result = categoryAction.GetCategoryByName(expectedCategory.categoryName)

        // Assert
        assertEquals(expectedCategory, result)
    }
}