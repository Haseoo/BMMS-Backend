package com.github.haseoo.bmms.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Offer(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "COMPANY_ID")
    var company: Company?,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "MATERIAL_ID")
    var material: Material?,
    @field:Column(nullable = false, scale = 10, precision = 2)
    var price: BigDecimal,
    var unit: String,
    var comments: String?,
    @field:Column(nullable = false)
    var lastModification: LocalDateTime?,
)
