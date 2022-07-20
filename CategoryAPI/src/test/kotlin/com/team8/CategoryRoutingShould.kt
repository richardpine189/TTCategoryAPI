package com.team8

import com.team8.models.Category
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import org.junit.Test
import kotlin.reflect.typeOf
import kotlin.test.assertNotNull
import kotlin.test.assertTrue


class CategoryRoutingShould {

    @Test
    fun `Get OK Status when GetAllCategories`() {
        testApplication {
            val response = client.get("/Categories")
            assertEquals(HttpStatusCode.OK, response.status)
        }
    }

    @Test
    fun `Get a list from when GetAllCategories`(){
        testApplication {
            val response = client.get("/Categories")
            val arrayCat = response.bodyAsText()
            val categories = Json.decodeFromString<Array<Category>>(arrayCat);

            // How to mock the action in a test?

            assertTrue { categories is Array<Category> }
        }
    }

    @Test
    fun `Get list with amount 2`(){
        testApplication {
            val expectedSize = 2
            val response = client.get("/Categories/${expectedSize}")

            val deserializedResponse = Json.decodeFromString<Array<String>>(response.bodyAsText())

            assertEquals(expectedSize, deserializedResponse.size)
        }
    }

    @Test
    fun `Get list with amount 3`(){
        testApplication {
            val expectedSize = 3
            val response = client.get("/Categories/${expectedSize}")

            val deserializedResponse = Json.decodeFromString<Array<String>>(response.bodyAsText())

            assertEquals(expectedSize, deserializedResponse.size)
        }
    }
}