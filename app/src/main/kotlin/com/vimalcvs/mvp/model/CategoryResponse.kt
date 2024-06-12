package com.vimalcvs.mvp.model

data class CategoryResponse(
    val status: String,
    val count: Int,
    val categories: List<Category>
)

