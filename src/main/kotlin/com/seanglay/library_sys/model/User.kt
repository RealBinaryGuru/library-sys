package com.seanglay.library_sys.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class Users(
    @Id val id: String? = null,
    @Indexed(unique = true)
    val username: String, val password: String
)
