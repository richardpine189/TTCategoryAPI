package com.team8.Interfaces

interface ICategoryRepository {
    fun GetCategories(amountCategories:Int) : Array<String>
}