package com.team8

import com.google.gson.Gson
import com.team8.plugins.prueba
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import org.junit.Test
import kotlin.reflect.typeOf
import kotlin.test.assertNotNull


class CategoryRoutingShould {

    @Test
    fun `Get OK Status when GetAllCategories`() {
        testApplication {
            val response = client.get("/Categories")
            assertEquals(HttpStatusCode.OK, response.status)

            //assertEquals("Hello, world!", response.bodyAsText())
        }
    }

    @Test
    fun `Get a list from when GetAllCategories`(){
        testApplication {
            val response = client.get("/Categories")
            val arrayCat = response.bodyAsText()
            //println(arrayCat.nameCat)
            val gson = Gson()
            val deserializeArrayCat = gson.fromJson(arrayCat, prueba::class.java)

            assertNotNull(arrayCat)
        }
    }

/*@Test
    fun testGetAllDog() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get,"/Categories").apply {
                assertEquals(HttpStatusCode.NotFound,response.status()
                )
            }
        }
    }*/
}