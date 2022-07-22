package com.github.haseoo.bmms.service

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.domain.ContactData

interface CompanyService {

    fun getAll(): Collection<Company>

    fun getCompanyById(id: Long): Company

    fun addCompany(company: Company): Company

    fun updateCompany(
        company: Company,
        contactDataToAdd: List<ContactData>,
        contactDataToUpdate: List<ContactData>,
        contactDataIdToDelete: List<Long>
    )

    fun removeCompanyById(id: Long)

}