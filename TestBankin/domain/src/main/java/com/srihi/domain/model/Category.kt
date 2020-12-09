package com.srihi.domain.model

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty


data class Category(
    val id: Long,
    @JsonProperty("resource_uri")
    val resourceUri: String,
    @JsonProperty("resource_type")
    val resourceType: String,
    val name: String,
    val parent: Parent?,
    val custom: Boolean,
    val other: Boolean,
    @JsonProperty("is_deleted")
    val isDeleted: Boolean,

    )