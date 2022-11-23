package com.example.onlineshoporder.controller

import com.example.onlineshoporder.dto.order.CreateOrderDto
import com.example.onlineshoporder.dto.order.OrderDto
import com.example.onlineshoporder.utility.Status
import org.springframework.http.ResponseEntity


interface OrderController {
    fun createOrder(createOrderDto: CreateOrderDto): ResponseEntity<OrderDto>
    fun getOrder(id: Long): ResponseEntity<OrderDto>
    fun updateOrder(id: Long, status: Status): ResponseEntity<Unit>
}