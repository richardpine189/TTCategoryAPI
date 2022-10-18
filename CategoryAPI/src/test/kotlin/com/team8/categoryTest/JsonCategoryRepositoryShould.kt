package com.team8.categoryTest

import com.team8.category.Interfaces.ICategoryRepository
import com.team8.category.repositories.JsonCategoryRepository
import com.team8.models.Category
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertArrayEquals
import org.junit.BeforeClass
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class JsonCategoryRepositoryShould {

    companion object{

        @JvmStatic
        lateinit var expectedCategories : Array<Category>
        @JvmStatic
        lateinit var expectedCategoryNames : Array<String>
        @JvmStatic
        lateinit var repository : ICategoryRepository

        @BeforeClass
        @JvmStatic
        fun `Set Up`()
        {
            expectedCategories = arrayOf(
                Category("Animales", arrayOf("Araña", "Delfin")),
                Category("Paises", arrayOf("Argentina", "Chile")),
                Category("Marcas", arrayOf("Etermax", "Asus"))
            )

            expectedCategoryNames = expectedCategories.map { it.categoryName }.toTypedArray()

            // Arrange
            repository = JsonCategoryRepository("./src/test/testCategories.json")
        }
    }

    @Test
    fun `Get category names`() = runTest {
        // Act
        val categoryNames : Array<String> = repository.getCategoryNames(3)

        // Assert
        assertArrayEquals(categoryNames, expectedCategoryNames);
    }

    @Test
    fun `Get categories `() = runTest {
        // Act
        val categories = repository.getCategories(3)

        // Assert
        assertEquals(categories.size, expectedCategories.size)
    }

    @Test
    fun `Get Category by Name`() = runTest {
        // Arrange
        val expectedCategory = expectedCategories[0]

        // Act
        val result = repository.getCategoryByName(expectedCategory.categoryName)

        // Assert
        assertEquals(expectedCategories[0], result)
    }

    @Test
    fun `Throw exception when category doesn't exist`() = runTest {
        // Assert
        assertFailsWith<NoSuchElementException>{
            // Act
            repository.getCategoryByName("UnKnowCategory")
        }
    }
}