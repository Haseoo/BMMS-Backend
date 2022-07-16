package com.github.haseoo.bmms.web

import com.github.haseoo.bmms.domain.Material
import com.github.haseoo.bmms.web.request.MaterialRequest
import com.github.haseoo.bmms.web.response.MaterialResponse

fun requestToDomain(materialRequest: MaterialRequest, id: Long? = null) = Material(
    id,
    materialRequest.name,
    materialRequest.specification,
    ArrayList()
)

fun domainToResponse(material: Material) = MaterialResponse(
    material.id!!,
    material.name,
    material.specification
)