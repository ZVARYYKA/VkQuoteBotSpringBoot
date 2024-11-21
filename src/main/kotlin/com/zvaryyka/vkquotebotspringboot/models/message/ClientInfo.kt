package com.zvaryyka.vkquotebotspringboot.models.message

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class ClientInfo {
    @JsonProperty("button_actions")
    private val buttonActions : Array<String>? = null

    private val keyboard : Boolean? = false

    private val inlineKeyboard : Boolean? = false

    @JsonProperty("land_id")
    private val langId : Int? = 0


}