package com.srihi.data.db

import com.srihi.data.db.entities.CategoryEntity
import com.srihi.domain.model.Category

fun mapCategoryToEntity(category: Category): CategoryEntity = CategoryEntity(
    idCategory = category.id,
    resourceUri = category.resourceUri,
    resourceType = category.resourceType,
    name = category.name,
    parent = category.parent,
    custom = category.custom,
    other = category.other,
    isDeleted = category.isDeleted
)

fun mapCategoryToEntities(categories: List<Category>): List<CategoryEntity> {
    val categoryList = mutableListOf<CategoryEntity>()
    for (category: Category in categories) {
        categoryList.add(mapCategoryToEntity(category))
    }
    return categoryList
}

fun mapCategoryToData(categoryEntity: CategoryEntity): Category = Category(
    id = categoryEntity.idCategory,
    resourceUri = categoryEntity.resourceUri,
    resourceType = categoryEntity.resourceType,
    name = categoryEntity.name,
    parent = categoryEntity.parent,
    custom = categoryEntity.custom,
    other = categoryEntity.other,
    isDeleted = categoryEntity.isDeleted
)

fun mapEntitiesToData(categoriesEntities: List<CategoryEntity>): List<Category> {
    val categoryList = mutableListOf<Category>()
    for (categoryEntity: CategoryEntity in categoriesEntities) {
        categoryList.add(mapCategoryToData(categoryEntity))
    }
    return categoryList
}