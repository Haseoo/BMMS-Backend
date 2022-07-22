package com.github.haseoo.bmms.repository.adapter

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.domain.Material
import com.github.haseoo.bmms.domain.Offer
import com.github.haseoo.bmms.domain.OrderList

interface BaseRepository<T> {

    fun findAll(): Collection<T>

    fun findById(id: Long): T?

    fun save(entity: T): T

    fun delete(entity: T)
}

interface OrderListRepositoryPort : BaseRepository<OrderList>

interface OfferRepositoryPort : BaseRepository<Offer> {
    fun findByCompanyId(id: Long): Collection<Offer>

    fun findByMaterialId(id: Long): Collection<Offer>
}

interface MaterialRepositoryPort : BaseRepository<Material>

interface CompanyRepositoryPort : BaseRepository<Company>