package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator
import javax.validation.Valid
import javax.validation.constraints.NotBlank


data class CompanyUpdateRequest
@JsonCreator
constructor(
    @field:NotBlank(message = "Provide company address")
    val address: String,
    @field:NotBlank(message = "Provide company city")
    val city: String,
    @field:NotBlank(message = "Provide company voivodeship")
    val voivodeship: String,
    @field:Valid
    val addedContactData: Collection<ContactDataRequest>,
    @field:Valid
    val updatedContactData: Map<Long, ContactDataRequest>,
    val deletedContactDataIds: Collection<Long>

)
