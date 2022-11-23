package com.example.onlineshoporder.controller

import com.example.onlineshoporder.controller.OrderControllerImpl.Companion.BASE_ORDER_URL
import com.example.onlineshoporder.dto.ProductDto
import com.example.onlineshoporder.dto.UserDto
import com.example.onlineshoporder.dto.order.CreateOrderDto
import com.example.onlineshoporder.dto.order.OrderDto
import com.example.onlineshoporder.service.OrderService
import com.example.onlineshoporder.utility.Status
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [BASE_ORDER_URL])
class OrderControllerImpl(private val orderService: OrderService) : OrderController {
    @PostMapping
    override fun createOrder(@RequestBody createOrderDto: CreateOrderDto): ResponseEntity<OrderDto> {
        val orderDto = orderService.createOrder(createOrderDto)
        return ResponseEntity<OrderDto>(orderDto, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    override fun getOrder(@PathVariable id: Long): ResponseEntity<OrderDto> {
        val orderDto = orderService.getOrder(id)
        return ResponseEntity<OrderDto>(orderDto, HttpStatus.OK)

    }

    @PutMapping("/{id}")
    override fun updateOrder(@PathVariable id: Long, @RequestBody status: Status): ResponseEntity<Unit> {
        return ResponseEntity(orderService.updateOrder(id, status), HttpStatus.NO_CONTENT)
    }

    companion object {
        const val BASE_ORDER_URL = "/api/order"
    }
}