package com.vimalcvs.mvp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<RoomEntity>)

    @Query("SELECT * FROM category_table")
    fun getAllCategories(): LiveData<List<RoomEntity>>
}