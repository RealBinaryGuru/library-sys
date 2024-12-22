package com.seanglay.library_sys.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "books")
data class Books(
    @Id val id: String? = null,
    var title: String?,
    var author: String?,
    var description: String?,
    var price: BigDecimal,
    var genre: String?,
    var publishedDate: String?
)