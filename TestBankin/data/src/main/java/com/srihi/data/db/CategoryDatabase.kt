package com.srihi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srihi.data.db.dao.CategoryDao
import com.srihi.data.db.entities.CategoryEntity


const val DATABASE_VERSION = 1

@Database(entities = [CategoryEntity::class], version = DATABASE_VERSION)
abstract class CategoryDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}