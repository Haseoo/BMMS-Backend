package com.github.haseoo.bmms.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ContactData(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var description: String?,
    var representativeNameAndSurname: String,
    var emailAddress: String?,
    var phoneNumber: String?
)
