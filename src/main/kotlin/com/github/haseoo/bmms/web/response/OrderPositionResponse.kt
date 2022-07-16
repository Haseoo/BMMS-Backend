package com.github.haseoo.bmms.web.response

data class OrderPositionResponse(
    var id: Long,
    val offer: OfferResponse,
    var quantity: Int
)
