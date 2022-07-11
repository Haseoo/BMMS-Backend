package com.github.haseoo.bmms.service

import com.github.haseoo.bmms.domain.Company

interface CompanyService {

    fun getAll(): Collection<Company>

}