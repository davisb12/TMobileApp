package com.example.tmobileapp.repo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmobileapp.model.Page
import kotlinx.coroutines.flow.Flow

@Dao
interface PageDao {

    @Query("SELECT * FROM page")
    fun getPage(): Flow<List<Page>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(page: Page)

    @Query("DELETE FROM page")
    suspend fun deleteAll()
}