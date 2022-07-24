package com.github.haseoo.bmms.service

import com.github.haseoo.bmms.domain.Offer

interface OfferService {

    fun getOfferById(offerId: Long): Offer

    fun addOffer(materialId: Long, companyId: Long, offer: Offer): Offer

    fun updateOffer(offer: Offer)

    fun deleteOffer(id: Long)

    fun getCompanyOffers(companyId: Long): Collection<Offer>

    fun getMaterialOffers(materialId: Long): Collection<Offer>

}