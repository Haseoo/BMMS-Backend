package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator

data class OrderPositionRequest
@JsonCreator
constructor(val offerId: Long, val quantity: Int)
