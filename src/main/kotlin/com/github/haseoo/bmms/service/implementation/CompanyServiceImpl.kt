package com.github.haseoo.bmms.service.implementation

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.repository.adapter.CompanyRepositoryPort
import com.github.haseoo.bmms.service.CompanyService
import org.springframework.stereotype.Service

@Service
private class CompanyServiceImpl(
    private val companyRepository: CompanyRepositoryPort
) : CompanyService {
    override fun getAll(): Collection<Company> = companyRepository.findAll()
}