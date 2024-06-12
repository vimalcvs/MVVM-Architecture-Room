package com.vimalcvs.mvp.intent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vimalcvs.mvp.room.RoomDB
import com.vimalcvs.mvp.room.RoomEntity
import com.vimalcvs.mvp.repository.RetrofitInstance
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val categoryDao = RoomDB.getDatabase(application).categoryDao()
    private val repository = CategoryRepository(RetrofitInstance.api, categoryDao)

    val allCategories: LiveData<List<RoomEntity>> = repository.allCategories

    init {
        viewModelScope.launch {
            repository.fetchCategories()
        }
    }
}
