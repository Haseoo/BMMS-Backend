package com.github.haseoo.bmms.web.response

data class ContactDataResponse(
    val id: Long,
    val description: String?,
    val representativeNameAndSurname: String,
    val emailAddress: String?,
    val phoneNumber: String?
)
