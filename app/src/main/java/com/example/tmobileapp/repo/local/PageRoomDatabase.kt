package com.example.tmobileapp.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tmobileapp.model.Page

@Database(entities = [Page::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PageRoomDatabase : RoomDatabase() {
    abstract fun pageDao(): PageDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PageRoomDatabase? = null

        fun getDatabase(context: Context): PageRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, PageRoomDatabase::class.java, "page_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}