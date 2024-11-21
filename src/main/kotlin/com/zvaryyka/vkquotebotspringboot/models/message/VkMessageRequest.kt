package com.zvaryyka.vkquotebotspringboot.models.message

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Data

@Data
class VkMessageRequest {
    @JsonProperty("user_id")
    var userId: Int = 0

    @JsonProperty("random_id")
    var randomId: Int = 0

    var message: String = ""
    var accessToken: String = ""

    @JsonProperty("v")
    var version: String = ""
}