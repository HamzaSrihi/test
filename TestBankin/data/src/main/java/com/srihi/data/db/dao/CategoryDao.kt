package com.srihi.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.srihi.data.db.entities.CATEGORY_PARENT
import com.srihi.data.db.entities.CATEGORY_TABLE
import com.srihi.data.db.entities.CategoryEntity
import com.srihi.data.db.entities.PARENT_ID
import com.srihi.domain.model.Category
import com.srihi.domain.model.Parent
import io.reactivex.Observable

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: List<CategoryEntity>)

    //Method to get parent categories
    @Query("SELECT * FROM $CATEGORY_TABLE WHERE $PARENT_ID = null")
    fun getParentCategories(): Observable<List<CategoryEntity>>

    @Query("SELECT * FROM $CATEGORY_TABLE WHERE $PARENT_ID = :id")
    fun getSousCategories(id: Long): Observable<List<CategoryEntity>>


}