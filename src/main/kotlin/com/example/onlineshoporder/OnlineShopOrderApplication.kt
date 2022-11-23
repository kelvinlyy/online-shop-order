package com.example.onlineshoporder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class OnlineShopOrderApplication

fun main(args: Array<String>) {
	runApplication<OnlineShopOrderApplication>(*args)
}
