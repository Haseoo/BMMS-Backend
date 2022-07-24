package com.github.haseoo.bmms.service

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.domain.ContactData

interface CompanyService {

    fun getAll(): Collection<Company>

    fun getCompanyById(id: Long): Company

    fun addCompany(company: Company): Company

    fun updateCompany(
        company: Company,
        contactDataToAdd: Collection<ContactData>,
        contactDataToUpdate: Collection<ContactData>,
        contactDataIdToDelete: Collection<Long>
    )

    fun removeCompanyById(id: Long)

}