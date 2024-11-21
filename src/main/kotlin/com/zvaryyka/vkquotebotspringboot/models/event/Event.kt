package com.zvaryyka.vkquotebotspringboot.models.event

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class  Event {
    private val type : String? = ""

    @JsonProperty("event_id")
    private val eventId : Int? = 0

    private val v : String? = ""

    private val `object` : EventObject? = null

    @JsonProperty("group_id")
    private val groupId : Int? = 0



}