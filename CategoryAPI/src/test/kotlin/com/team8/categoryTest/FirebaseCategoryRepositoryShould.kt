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
}