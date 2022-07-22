package com.github.haseoo.bmms.service.implementation

import com.github.haseoo.bmms.domain.Offer
import com.github.haseoo.bmms.exception.NotFoundException
import com.github.haseoo.bmms.repository.adapter.OfferRepositoryPort
import com.github.haseoo.bmms.service.CompanyService
import com.github.haseoo.bmms.service.MaterialService
import com.github.haseoo.bmms.service.OrderService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class OrderServiceImpl(
    val offerRepositoryPort: OfferRepositoryPort,
    val materialService: MaterialService,
    val companyService: CompanyService
) : OrderService {
    override fun getOfferById(offerId: Long) =
        offerRepositoryPort.findById(offerId) ?: throw NotFoundException("Offer", offerId)

    @Transactional
    override fun addOrder(materialId: Long, companyId: Long, offer: Offer): Offer {
        offer.material = materialService.getMaterialById(materialId)
        offer.company = companyService.getCompanyById(companyId)
        offer.lastModification = LocalDateTime.now()
        return offerRepositoryPort.save(offer)
    }

    @Transactional
    override fun updateOffer(offer: Offer) {
        val existingOffer = getOfferById(offer.id!!)
        existingOffer.price = offer.price
        existingOffer.unit = offer.unit
        existingOffer.comments = offer.comments
        existingOffer.lastModification = LocalDateTime.now()
    }

    @Transactional
    override fun deleteOffer(id: Long) = offerRepositoryPort.delete(getOfferById(id))

    override fun getCompanyOffers(companyId: Long) = offerRepositoryPort.findByCompanyId(companyId)

    override fun getMaterialOffers(materialId: Long) = offerRepositoryPort.findByMaterialId(materialId)
}