package com.team8

import com.team8.Interfaces.ICategoryRepository
import com.team8.models.Category
import com.team8.plugins.repository
import com.team8.repositories.JsonCategoryRepository
import org.junit.Test
import org.junit.Assert.assertArrayEquals
import org.junit.BeforeClass
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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
    fun `Get category names`()
    {
        // Act
        val categoryNames : Array<String> = repository.GetCategoryNames(3)

        // Assert
        assertArrayEquals(categoryNames, expectedCategoryNames);
    }

    @Test
    fun `Get categories `()
    {
        // Act
        val categories = repository.GetCategories(3)

        // Assert
        assertArrayEquals(categories, expectedCategories)
    }

    @Test
    fun `Get Category by Name`()
    {
        // Arrange
        val expectedCategory = expectedCategories[0]

        // Act
        val result = repository.GetCategoryByName(expectedCategory.categoryName)

        // Assert
        assertEquals(expectedCategories[0], result)
    }

    @Test
    fun `Throw exception when category doesn't exist`()
    {
        // Assert
        assertFailsWith<NoSuchElementException>{
            // Act
            repository.GetCategoryByName("test")
        }
    }
}