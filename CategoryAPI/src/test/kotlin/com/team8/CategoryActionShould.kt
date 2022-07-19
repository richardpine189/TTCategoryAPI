package com.team8
import com.team8.Interfaces.*
import com.team8.models.*
import junit.framework.TestCase.*
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*


class CategoryActionShould {
    companion object {

        @JvmStatic
        lateinit var categoryAction: CategoryAction
        @JvmStatic
        lateinit var initializeArray: Array<String>

        @BeforeClass
        @JvmStatic
        fun `Setup`() {
            initializeArray = arrayOf("cosas", "frutas", "nombres", "paises", "famosos")
            val categoryRepository: ICategoryRepository = mock()
            whenever(categoryRepository.GetCategories(5)).thenReturn(initializeArray)
            whenever(categoryRepository.GetCategories(1)).thenReturn(initializeArray.sliceArray(0..0))
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


}