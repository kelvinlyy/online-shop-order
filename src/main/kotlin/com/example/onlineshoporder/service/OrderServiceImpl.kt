package com.example.onlineshoporder.service

import com.example.onlineshoporder.dto.ProductDto
import com.example.onlineshoporder.dto.UserDto
import com.example.onlineshoporder.dto.order.CreateOrderDto
import com.example.onlineshoporder.dto.order.OrderDto
import com.example.onlineshoporder.utility.Status
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService {
    override fun createOrder(createOrderDto: CreateOrderDto): OrderDto {
        val orderDto = OrderDto(1, ProductDto(1, ""), UserDto(1, "", ""), Status.TO_BE_PAID)
        return orderDto
    }

    override fun getOrder(id: Long): OrderDto {
        val orderDto = OrderDto(1, ProductDto(1, ""), UserDto(1, "", ""), Status.TO_BE_PAID)
        return orderDto
    }

    override fun updateOrder(id: Long, status: Status) {
        return
    }
}