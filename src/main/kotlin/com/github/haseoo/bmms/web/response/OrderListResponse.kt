package com.github.haseoo.bmms.web.response

import java.time.LocalDateTime

data class OrderListResponse(
    val id: Long,
    val name: String,
    val lastModification: LocalDateTime,
    val positions: List<OrderPositionResponse>
)
