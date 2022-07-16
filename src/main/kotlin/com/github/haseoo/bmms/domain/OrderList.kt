package com.github.haseoo.bmms.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class OrderList(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var lastModification: LocalDateTime,
    @field:OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    @field:JoinColumn(name = "ORDER_LIST_ID")
    var positions: List<OrderPosition>
)
