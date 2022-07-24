package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator
import javax.validation.constraints.NotBlank

data class OrderListRequest
@JsonCreator
constructor(@field:NotBlank(message = "Provide order list name") val name: String)
