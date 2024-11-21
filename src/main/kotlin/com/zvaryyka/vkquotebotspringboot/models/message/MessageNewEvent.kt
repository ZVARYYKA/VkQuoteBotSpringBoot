package com.zvaryyka.vkquotebotspringboot.models.message

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class MessageNewEvent {
    val type: String = ""

    @JsonProperty("group_id")
    val groupId: Int = 0

    @JsonProperty("event_id")
    val eventId: String = ""

    val v: String = ""

    val `object`: MessageObject? = null
}