package com.example.onlineshoporder.service

import com.example.onlineshoporder.dto.order.CreateOrderDto
import com.example.onlineshoporder.dto.order.OrderDto
import com.example.onlineshoporder.utility.Status


interface OrderService {
    fun createOrder(createOrderDto: CreateOrderDto): OrderDto
    fun getOrder(id: Long): OrderDto
    fun updateOrder(id: Long, status: Status)
}