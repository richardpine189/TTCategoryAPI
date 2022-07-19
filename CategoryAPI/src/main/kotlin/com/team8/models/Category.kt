package com.team8.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(val categoryName: String, val words: Array<String>)

