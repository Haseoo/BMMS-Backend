package com.github.haseoo.bmms.web.response


data class CompanyResponse(
    val id: Long,
    val name: String,
    val address: String,
    val city: String?,
    val voivodeship: String?,
    val contactData: List<ContactDataResponse>
)
