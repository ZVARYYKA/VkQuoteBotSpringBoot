package com.zvaryyka.vkquotebotspringboot.service

import com.zvaryyka.vkquotebotspringboot.models.message.VkMessageRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.util.UriComponentsBuilder
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Service
@Slf4j
class SendMessageService (
    private val restTemplate : RestTemplate
) {

    private val log = LoggerFactory.getLogger(SendMessageService::class.java)


    fun sendMessage(vkMessageRequest: VkMessageRequest) {
        val encodedMessage : String

        try {
            encodedMessage = URLEncoder.encode(vkMessageRequest.message, StandardCharsets.UTF_8.toString())
        }
        catch (e: UnsupportedEncodingException ) {
            log.error("Failed to encode message: {}", vkMessageRequest.message, e);
            return;
        }
        val uri : String = UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("user_id", vkMessageRequest.userId)
                .queryParam("message", encodedMessage)
                .queryParam("random_id", vkMessageRequest.randomId)
                .queryParam("access_token", vkMessageRequest.accessToken)
                .queryParam("v", vkMessageRequest.version)
                .toUriString();

        val response : ResponseEntity<String> =  restTemplate.getForEntity(uri,String)
        log.info("Response from Vk Server: {}", response.body);



    }

}