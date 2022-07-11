package com.github.haseoo.bmms.repository.port

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.repository.adapter.CompanyRepository
import com.github.haseoo.bmms.repository.jpa.CompanyJpaRepository
import org.springframework.stereotype.Repository

@Repository
private class CompanyRepositoryPort(repository: CompanyJpaRepository) : CompanyRepository,
    BaseRepositoryImpl<Company>(repository)