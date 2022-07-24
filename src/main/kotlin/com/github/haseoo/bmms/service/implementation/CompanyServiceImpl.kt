package com.github.haseoo.bmms.service.implementation

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.domain.ContactData
import com.github.haseoo.bmms.exception.NotFoundException
import com.github.haseoo.bmms.repository.adapter.CompanyRepositoryPort
import com.github.haseoo.bmms.service.CompanyService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CompanyServiceImpl(
    private val companyRepository: CompanyRepositoryPort
) : CompanyService {
    override fun getAll(): Collection<Company> = companyRepository.findAll()
    override fun getCompanyById(id: Long): Company =
        companyRepository.findById(id) ?: throw NotFoundException("Company", id)

    @Transactional
    override fun addCompany(company: Company) = companyRepository.save(company)

    @Transactional
    override fun updateCompany(
        company: Company,
        contactDataToAdd: Collection<ContactData>,
        contactDataToUpdate: Collection<ContactData>,
        contactDataIdToDelete: Collection<Long>
    ) {
        val existingCompany = getCompanyById(company.id!!)
        existingCompany.name = company.name
        existingCompany.address = company.address
        existingCompany.city = company.city
        existingCompany.voivodeship = company.voivodeship
        existingCompany.contactData -= contactDataToAdd.filter { contactDataIdToDelete.contains(it.id) }
        contactDataToUpdate.forEach { toUpdate ->
            updateContactData(toUpdate, existingCompany.contactData.find { it.id == toUpdate.id })
        }
        existingCompany.contactData += contactDataToAdd
    }

    @Transactional
    override fun removeCompanyById(id: Long) = companyRepository.delete(getCompanyById(id))

    private fun updateContactData(toUpdate: ContactData, existing: ContactData?) {
        if (existing == null) {
            return
        }
        existing.description = toUpdate.description
        existing.emailAddress = toUpdate.emailAddress
        existing.phoneNumber = toUpdate.phoneNumber
    }


}