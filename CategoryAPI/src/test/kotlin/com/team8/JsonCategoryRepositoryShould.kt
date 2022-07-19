package com.team8

import com.team8.repositories.JsonCategoryRepository
import org.junit.Test
import junit.framework.TestCase.*

class JsonCategoryRepositoryShould {

    val expectedCategoryNames = arrayOf("Animales", "Paises")

    @Test
    fun `Get category names`()
    {
        // Arrange
        val repository = JsonCategoryRepository("./src/test/testCategories.json")

        // Act
        val categories : Array<String> = repository.GetCategories(5)

        // Assert
        assertEquals(categories, expectedCategoryNames);
    }
}