package com.github.haseoo.bmms.web.controller

import com.github.haseoo.bmms.service.MaterialService
import com.github.haseoo.bmms.service.OfferService
import com.github.haseoo.bmms.web.domainToResponse
import com.github.haseoo.bmms.web.request.MaterialRequest
import com.github.haseoo.bmms.web.requestToDomain
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/material")
class MaterialController(
    private val materialService: MaterialService,
    private val offerService: OfferService
) {
    @GetMapping
    fun getAll() = ResponseEntity.ok(materialService.findAllMaterials().map { domainToResponse(it) })

    @PostMapping
    fun addMaterial(@RequestBody @Valid materialRequest: MaterialRequest) = ResponseEntity(
        domainToResponse(materialService.addMaterial(requestToDomain(materialRequest))),
        HttpStatus.CREATED
    )

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = ResponseEntity.ok(domainToResponse(materialService.getMaterialById(id)))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid materialRequest: MaterialRequest): ResponseEntity<Void> {
        materialService.updateMaterial(requestToDomain(materialRequest, id))
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        materialService.removeMaterialById(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}/offers")
    fun getMaterialOffers(@PathVariable id: Long) =
        ResponseEntity.ok(offerService.getMaterialOffers(id).map { domainToResponse(it) })
}