package com.team8

import com.team8.models.Category
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CategoryShould {

    @Test
    fun `Check word is in category`()
    {
        // Arrange
        val word = "Brasil"
        val category = Category("Paises", arrayOf("Argentina", word, "Chile"))

        // Assert
        assertTrue { category.ValidWord(word) }
    }

    @Test
    fun `Check word isn't in category`()
    {
        // Arrange
        val word = "China"
        val category = Category("Paises", arrayOf("Argentina", "Brasil", "Chile"))

        // Assert
        assertFalse { category.ValidWord(word) }
    }
}