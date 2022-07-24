package com.github.haseoo.bmms.web

import com.github.haseoo.bmms.domain.*
import com.github.haseoo.bmms.web.request.*
import com.github.haseoo.bmms.web.response.*

fun requestToDomain(materialRequest: MaterialRequest, id: Long? = null) = Material(
    id,
    materialRequest.name,
    materialRequest.specification,
    emptyList()
)

fun domainToResponse(material: Material) = MaterialResponse(
    material.id!!,
    material.name,
    material.specification
)

fun requestToDomain(contactDataRequest: ContactDataRequest, id: Long? = null) = ContactData(
    id,
    contactDataRequest.description,
    contactDataRequest.representativeNameAndSurname,
    contactDataRequest.emailAddress,
    contactDataRequest.phoneNumber
)

fun domainToResponse(contactData: ContactData) = ContactDataResponse(
    contactData.id!!,
    contactData.description,
    contactData.representativeNameAndSurname,
    contactData.emailAddress,
    contactData.phoneNumber
)

fun requestToDomain(companyAddRequest: CompanyAddRequest) = Company(
    null,
    companyAddRequest.name,
    companyAddRequest.address,
    companyAddRequest.city,
    companyAddRequest.voivodeship,
    companyAddRequest.contactData.map { requestToDomain(it) },
    emptyList()
)

fun requestToDomain(companyAddRequest: CompanyUpdateRequest, id: Long) = Company(
    id,
    companyAddRequest.name,
    companyAddRequest.address,
    companyAddRequest.city,
    companyAddRequest.voivodeship,
    emptyList(),
    emptyList()
)

fun domainToResponse(company: Company) = CompanyResponse(
    company.id!!,
    company.name,
    company.address,
    company.city,
    company.voivodeship,
    company.contactData.map { domainToResponse(it) }
)

fun requestToDomain(offerAddRequest: OfferAddRequest) = Offer(
    null,
    null,
    null,
    offerAddRequest.price,
    offerAddRequest.unit,
    offerAddRequest.comments,
    null
)

fun requestToDomain(offerUpdateRequest: OfferUpdateRequest, id: Long) = Offer(
    id,
    null,
    null,
    offerUpdateRequest.price,
    offerUpdateRequest.unit,
    offerUpdateRequest.comments,
    null
)

fun domainToResponse(offer: Offer) = OfferResponse(
    offer.id!!,
    domainToResponse(offer.company!!),
    domainToResponse(offer.material!!),
    offer.price,
    offer.unit,
    offer.comments,
    offer.lastModification!!
)

fun requestToDomain(orderPositionRequest: OrderPositionRequest) = OrderPosition(
    null,
    null,
    orderPositionRequest.quantity
)

fun domainToResponse(orderPosition: OrderPosition) = OrderPositionResponse(
    orderPosition.id!!,
    domainToResponse(orderPosition.offer!!),
    orderPosition.quantity
)

fun requestToDomain(orderListRequest: OrderListRequest) = OrderList(
    null,
    orderListRequest.name,
    null,
    emptyList()
)

fun domainToResponse(orderList: OrderList) = OrderListResponse(
    orderList.id!!,
    orderList.name,
    orderList.lastModification!!,
    orderList.positions.map { domainToResponse(it) }
)
