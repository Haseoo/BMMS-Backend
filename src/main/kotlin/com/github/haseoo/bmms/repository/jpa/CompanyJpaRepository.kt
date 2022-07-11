package com.github.haseoo.bmms.repository.jpa

import com.github.haseoo.bmms.domain.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyJpaRepository : JpaRepository<Company, Long>