package com.srihi.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *@property id
 * @property resourceUri
 * @property resourceType
 */
data class Parent(
    val id: Long?,
    @JsonProperty("resource_uri")
    val resourceUri: String?,
    @JsonProperty("resource_type")
    val resourceType: String?
)