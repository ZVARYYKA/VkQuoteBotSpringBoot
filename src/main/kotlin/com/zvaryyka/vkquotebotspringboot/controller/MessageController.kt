package com.zvaryyka.vkquotebotspringboot.controller

import com.zvaryyka.vkquotebotspringboot.models.message.MessageNewEvent
import com.zvaryyka.vkquotebotspringboot.models.message.VkMessageRequest
import com.zvaryyka.vkquotebotspringboot.service.SendMessageService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicInteger

@RestController
class MessageController(
    private val sendMessageService: SendMessageService
) {

    @Value("\${vk.api.token}")
    private lateinit var vkApiToken: String

    @Value("\${vk.api.version}")
    private lateinit var vkApiVersion: String

    private val counter = AtomicInteger(0)
    private val log = LoggerFactory.getLogger(MessageController::class.java)

    @PostMapping("/newMessage")
    fun receiveNewMessageAndGiveResponse(@RequestBody event: MessageNewEvent): String {
        log.info("Received event: {}", event)

        val messageText = event.`object`?.message?.text ?: ""
        val userId = event.`object`?.message?.fromId ?: 0
        log.info("Message text: {}", messageText)

        // Генерация уникального random_id на основе комбинации текущего времени, случайного числа и счетчика
        // Коллизия мало вероятна!
        val timeComponent = Instant.now().toEpochMilli()
        val randomComponent = ThreadLocalRandom.current().nextInt(1, Int.MAX_VALUE)
        val countComponent = counter.getAndIncrement()
        val randomId = ((timeComponent + randomComponent + countComponent) and 0xFFFFFFFF).toInt()
        log.info("Random id {}", randomId)

        val vkMessageRequest = VkMessageRequest()
        vkMessageRequest.userId = userId
        vkMessageRequest.randomId = randomId
        vkMessageRequest.message = "You say $messageText"
        vkMessageRequest.accessToken = vkApiToken
        vkMessageRequest.version = vkApiVersion

        sendMessageService.sendMessage(vkMessageRequest)

        return "ok"
    }
}