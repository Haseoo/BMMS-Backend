package com.github.haseoo.bmms.web.response

import java.math.BigDecimal
import java.time.LocalDateTime

data class OfferResponse(
    val id: Long,
    val company: CompanyResponse,
    val material: MaterialResponse,
    val price: BigDecimal,
    val unit: String,
    val comments: String,
    val lastModification: LocalDateTime
)
