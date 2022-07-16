package com.github.haseoo.bmms.web.request

import com.fasterxml.jackson.annotation.JsonCreator
import javax.validation.constraints.NotBlank

data class MaterialRequest
@JsonCreator
constructor(
    @field:NotBlank(message = "Provide material name")
    val name: String,
    val specification: String?
)