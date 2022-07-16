package com.github.haseoo.bmms.domain

import javax.persistence.*

@Entity
data class OrderPosition(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "OFFER_ID")
    val offer: Offer,
    @field:Column(nullable = false)
    var quantity: Int
)
