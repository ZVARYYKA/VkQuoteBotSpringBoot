package com.zvaryyka.vkquotebotspringboot.models.event

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class EventObject {
    @JsonProperty("user_id")
    private val userId: Int? = null

    @JsonProperty("join_type")
    private val joinType : String? = ""
}