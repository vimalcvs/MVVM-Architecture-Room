package com.vimalcvs.mvp.intent

import androidx.lifecycle.LiveData
import com.vimalcvs.mvp.room.RoomDao
import com.vimalcvs.mvp.room.RoomEntity
import com.vimalcvs.mvp.repository.ApiService

class CategoryRepository(private val apiService: ApiService, private val categoryDao: RoomDao) {

    val allCategories: LiveData<List<RoomEntity>> = categoryDao.getAllCategories()

    suspend fun fetchCategories() {
        val response = apiService.getCategories()
        if (response.status == "ok") {
            categoryDao.insertAll(response.categories.map {
                RoomEntity(it.cid, it.category_name, it.category_image, it.radio_count)
            })
        }
    }
}
