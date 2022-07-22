package com.github.haseoo.bmms.domain

import javax.persistence.*

@Entity
data class Company(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var address: String,
    var city: String?,
    var voivodeship: String?,
    @field:OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    @field:JoinColumn(name = "COMPANY_ID")
    var contactData: List<ContactData>,
    @field:OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "company")
    var offers: List<Offer>

)
