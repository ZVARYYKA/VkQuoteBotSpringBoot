package com.zvaryyka.vkquotebotspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class VkQuoteBotSpringBootApplication

fun main(args: Array<String>) {
    runApplication<VkQuoteBotSpringBootApplication>(*args)
}

@Bean
fun getRestTemplate(): RestTemplate = RestTemplate();
