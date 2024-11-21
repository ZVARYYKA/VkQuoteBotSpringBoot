package com.zvaryyka.vkquotebotspringboot.models.message

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class MessageObject {
    val message: Message? = null

    @JsonProperty("client_info")
    val clientInfo: ClientInfo? = null
}