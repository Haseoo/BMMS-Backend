package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator
import javax.validation.Valid
import javax.validation.constraints.NotBlank


data class CompanyAddRequest
@JsonCreator
constructor(
    @field:NotBlank(message = "Provide company name")
    val name: String,
    @field:NotBlank(message = "Provide company address")
    val address: String,
    @field:NotBlank(message = "Provide company city")
    val city: String,
    @field:NotBlank(message = "Provide company voivodeship")
    val voivodeship: String,
    @field:Valid
    val contactData: Collection<ContactDataRequest>

)
