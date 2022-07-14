package com.github.haseoo.bmms.domain

import javax.persistence.*

@Entity
data class Material(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val specification: String,
    @field:OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "material")
    var offers: List<Offer>
)