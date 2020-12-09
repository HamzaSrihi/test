package com.srihi.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.srihi.domain.model.Parent

const val CATEGORY_TABLE = "category"
const val CATEGORY_ID = "idCategory"
const val CATEGORY_RESOURCEURI = "resource_uri"
const val CATEGORY_RESOURCETYPE = "resource_type"
const val CATEGORY_NAME = "name"
const val CATEGORY_PARENT = "parent"
const val PARENT_ID = "id"
const val CATEGORY_CUSTOM = "custom"
const val CATEGORY_OTHER = "other"
const val CATEGORY_ISDELETED = "is_deleted"

@Entity(tableName = CATEGORY_TABLE)
data class CategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = CATEGORY_ID)
    val idCategory: Long,

    @ColumnInfo(name = CATEGORY_RESOURCEURI)
    val resourceUri: String,

    @ColumnInfo(name = CATEGORY_RESOURCETYPE)
    val resourceType: String,

    @ColumnInfo(name = CATEGORY_NAME)
    val name: String,

    @Embedded
    val parent: Parent?,

    @ColumnInfo(name = CATEGORY_CUSTOM)
    val custom: Boolean,

    @ColumnInfo(name = CATEGORY_OTHER)
    val other: Boolean,

    @ColumnInfo(name = CATEGORY_ISDELETED)
    val isDeleted: Boolean
)