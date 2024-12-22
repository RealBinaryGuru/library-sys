package com.seanglay.library_sys.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "reviews")
data class Reviews(
    @Id val id: String? = null,
    val bookId: String,
    val userId: String,
    val rating: Int,
    val comment: String,
    val reviewDate: String
)
