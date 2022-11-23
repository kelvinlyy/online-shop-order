package com.example.onlineshoporder.controller

import com.example.onlineshoporder.controller.OrderControllerImpl.Companion.BASE_ORDER_URL
import com.example.onlineshoporder.dto.ProductDto
import com.example.onlineshoporder.dto.UserDto
import com.example.onlineshoporder.dto.order.CreateOrderDto
import com.example.onlineshoporder.service.OrderService
import com.example.onlineshoporder.utility.Status
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class OrderControllerImplTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {

    @RelaxedMockK
    lateinit var orderService: OrderService

    @Test
    fun `should create an order`() {
        // given
        val newOrder = CreateOrderDto(
            ProductDto(1, "product-1"),
            UserDto(1, "name-1", "address-1")
        )


        // when/then
        mockMvc.post(BASE_ORDER_URL) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newOrder)
        }
            .andDo { print() }
            .andExpect {
                status { isCreated() }
            }
            .andReturn()

    }

    @Test
    fun `should get an order`() {
        // when/then
        mockMvc.get("$BASE_ORDER_URL/1") {
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isOk() }
            }
            .andReturn()

    }

    @Test
    fun `should update an order`() {
        // when/then
        mockMvc.put("$BASE_ORDER_URL/1") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(Status.COMPLETED)
        }
            .andDo { print() }
            .andExpect {
                status { isNoContent() }
            }
            .andReturn()

    }

}