package com.team8.categoryTest

import com.team8.category.repositories.FirebaseCategoryRepository
import org.junit.Test
import kotlinx.coroutines.test.runTest

class FirebaseCategoryRepositoryShould {

    @Test
    fun getCategoryNamesFromRepository() = runTest{
        val repository = FirebaseCategoryRepository("https://topic-twister-categories-default-rtdb.firebaseio.com")

        val categoryNames = repository.getCategoryNames(5)

        println(categoryNames)
    }

    @Test
    fun getAllCategoriesFromRepository() = runTest{
        val repository = FirebaseCategoryRepository("https://topic-twister-categories-default-rtdb.firebaseio.com")

        val categories = repository.getAllCategories()

        println(categories)
    }

    @Test
    fun getCategoryByName() = runTest {
        val repository = FirebaseCategoryRepository("https://topic-twister-categories-default-rtdb.firebaseio.com")

        val category = repository.getCategoryByName("Animales")

        println(category)
    }
}