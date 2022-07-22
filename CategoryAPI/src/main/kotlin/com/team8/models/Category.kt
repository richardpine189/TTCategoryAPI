package com.team8.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(val categoryName: String, val words: Array<String>) {

    fun ValidWord(word : String) : Boolean
    {
        return words.contains(word)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (categoryName != other.categoryName) return false
        if (!words.contentEquals(other.words)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = categoryName.hashCode()
        result = 31 * result + words.contentHashCode()
        return result
    }
}
