package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class OfferAddRequest
@JsonCreator
constructor(
    @field:NotNull(message = "Provide offer company")
    val companyId: Long,
    @field:NotNull(message = "Provide offer material")
    val materialId: Long,
    @field:NotNull(message = "Provide offer price")
    val price: BigDecimal,
    @field:NotBlank(message = "Provide unit")
    val unit: String,
    val comments: String?
)
