package com.example.onlineshoporder.dto.order

import com.example.onlineshoporder.dto.ProductDto
import com.example.onlineshoporder.dto.UserDto

data class CreateOrderDto(
    val product: ProductDto,
    val buyer: UserDto

)
