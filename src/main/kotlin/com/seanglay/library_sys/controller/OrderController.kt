package com.seanglay.library_sys.controller

import com.seanglay.library_sys.model.Orders
import com.seanglay.library_sys.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {
    @PostMapping
    fun placeOrder(@RequestBody order: Orders): ResponseEntity<Orders> {
        return ResponseEntity.ok(orderService.placeOrder(order))
    }
}