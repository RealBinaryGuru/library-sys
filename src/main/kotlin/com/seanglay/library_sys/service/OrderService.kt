package com.seanglay.library_sys.service

import com.seanglay.library_sys.model.Orders
import com.seanglay.library_sys.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {
    fun placeOrder(order: Orders): Orders {
        return orderRepository.save(order)
    }
}