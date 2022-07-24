package com.github.haseoo.bmms.web.controller

import com.github.haseoo.bmms.service.OfferService
import com.github.haseoo.bmms.web.domainToResponse
import com.github.haseoo.bmms.web.request.OfferAddRequest
import com.github.haseoo.bmms.web.request.OfferUpdateRequest
import com.github.haseoo.bmms.web.requestToDomain
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/material")
class OfferController(private val offerService: OfferService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = ResponseEntity.ok(domainToResponse(offerService.getOfferById(id)))

    @PostMapping
    fun addOffer(@RequestBody @Valid offerAddRequest: OfferAddRequest) =
        ResponseEntity(
            domainToResponse(
                offerService.addOffer(
                    offerAddRequest.materialId,
                    offerAddRequest.companyId,
                    requestToDomain(offerAddRequest)
                )
            ),
            HttpStatus.CREATED
        )

    @PutMapping("/{id}")
    fun updateOffer(
        @PathVariable id: Long,
        @RequestBody @Valid offerUpdateRequest: OfferUpdateRequest
    ): ResponseEntity<Void> {
        offerService.updateOffer(requestToDomain(offerUpdateRequest, id))
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/id")
    fun deleteOffer(@PathVariable id: Long) = offerService.deleteOffer(id)

}