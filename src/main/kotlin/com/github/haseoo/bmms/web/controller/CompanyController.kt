package com.github.haseoo.bmms.web.controller

import com.github.haseoo.bmms.service.CompanyService
import com.github.haseoo.bmms.service.OfferService
import com.github.haseoo.bmms.web.domainToResponse
import com.github.haseoo.bmms.web.request.CompanyAddRequest
import com.github.haseoo.bmms.web.request.CompanyUpdateRequest
import com.github.haseoo.bmms.web.requestToDomain
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/company")
class CompanyController(
    private val companyService: CompanyService,
    private val offerService: OfferService
) {

    @GetMapping
    fun getAllCompanies() = ResponseEntity.ok(companyService.getAll().map { domainToResponse(it) })

    @GetMapping("/{id}")
    fun getByCompanyId(@PathVariable id: Long) = ResponseEntity.ok(domainToResponse(companyService.getCompanyById(id)))

    @PostMapping
    fun addCompany(@RequestBody @Valid companyAddRequest: CompanyAddRequest) =
        ResponseEntity(companyService.addCompany(requestToDomain(companyAddRequest)), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun updateCompany(
        @PathVariable id: Long,
        @RequestBody @Valid companyUpdateRequest: CompanyUpdateRequest
    ): ResponseEntity<Void> {
        companyService.updateCompany(
            requestToDomain(companyUpdateRequest, id),
            companyUpdateRequest.addedContactData.map { requestToDomain(it) },
            companyUpdateRequest.updatedContactData.map { requestToDomain(it.value, it.key) },
            companyUpdateRequest.deletedContactDataIds
        )
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long) = companyService.removeCompanyById(id)

    @GetMapping("/{id}/offers")
    fun getCompanyOffers(@PathVariable id: Long) =
        ResponseEntity.ok(offerService.getCompanyOffers(id).map { domainToResponse(it) })

}