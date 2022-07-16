package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator
import javax.validation.constraints.NotBlank

data class ContactDataRequest
@JsonCreator
constructor(
    val description: String?,
    @field:NotBlank(message = "Provide surname and name for company representative")
    val representativeNameAndSurname: String,
    val emailAddress: String?,
    val phoneNumber: String?
)
