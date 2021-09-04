package com.example.comeoneinstein.dao

import androidx.room.*
import com.example.comeoneinstein.model.DataModel

@Dao
interface CountDao {
    @Insert
    fun insertUser(count: DataModel.Count): Long

    @Update
    fun updateUser(newCount: DataModel.Count)

    @Delete
    fun deleteUser(user: DataModel.Count)

}