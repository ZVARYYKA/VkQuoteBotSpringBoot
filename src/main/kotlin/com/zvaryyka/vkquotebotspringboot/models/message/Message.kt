package com.zvaryyka.vkquotebotspringboot.models.message

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class Message {
    val date: Long = 0L

    @JsonProperty("from_id")
    val fromId: Int = 0

    val id: Int = 0

    val out: Int = 0

    @JsonProperty("peer_id")
    val peerId: Int = 0

    val text: String = ""

    @JsonProperty("conversation_message_id")
    val conversationMessageId: Int = 0

    @JsonProperty("fwd_messages")
    val fwdMessages: Array<Any>? = null

    val important: Boolean = false

    @JsonProperty("random_id")
    val randomId: Int = 0

    val attachments: Array<Any>? = null

    @JsonProperty("is_hidden")
    val isHidden: Boolean = false
}