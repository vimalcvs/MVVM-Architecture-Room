package com.vimalcvs.mvp.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "category_table")
data class RoomEntity(
    @PrimaryKey(autoGenerate = false)
    val cid: Int,
    val category_name: String,
    val category_image: String,
    val radio_count: Int
) : Serializable