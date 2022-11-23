package com.example.onlineshoporder.dto.order

import com.example.onlineshoporder.dto.ProductDto
import com.example.onlineshoporder.dto.UserDto
import com.example.onlineshoporder.utility.Status

data class OrderDto(
    val id: Long,
    val product: ProductDto,
    val buyer: UserDto,
    val status: Status,

)
