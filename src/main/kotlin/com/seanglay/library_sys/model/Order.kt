package com.seanglay.library_sys.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

enum class OrderStatus {
    PENDING, COMPLETED, CANCELLED
}

@Document(collection = "orders")
data class Orders(
    @Id val id: String? = null,
    var userId: String?,
    var bookIds: List<String>,
    var totalAmount: BigDecimal?,
    var orderDate: LocalDateTime = LocalDateTime.now(),
    var status: OrderStatus = OrderStatus.PENDING
)

