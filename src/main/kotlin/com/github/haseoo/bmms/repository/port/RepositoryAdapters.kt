package com.github.haseoo.bmms.repository.port

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.domain.Material
import com.github.haseoo.bmms.domain.Offer
import com.github.haseoo.bmms.domain.OrderList
import com.github.haseoo.bmms.repository.adapter.CompanyRepositoryPort
import com.github.haseoo.bmms.repository.adapter.MaterialRepositoryPort
import com.github.haseoo.bmms.repository.adapter.OfferRepositoryPort
import com.github.haseoo.bmms.repository.adapter.OrderListRepositoryPort
import com.github.haseoo.bmms.repository.jpa.CompanyJpaRepository
import com.github.haseoo.bmms.repository.jpa.MaterialJpaRepository
import com.github.haseoo.bmms.repository.jpa.OfferJpaRepository
import com.github.haseoo.bmms.repository.jpa.OrderListJpaRepository
import org.springframework.stereotype.Repository

@Repository
private class CompanyRepositoryAdapter(repository: CompanyJpaRepository) : CompanyRepositoryPort,
    BaseRepositoryImpl<Company>(repository)

@Repository
private class MaterialRepositoryAdapter(repository: MaterialJpaRepository) : MaterialRepositoryPort,
    BaseRepositoryImpl<Material>(repository)

@Repository
private class OfferRepositoryAdapter(repository: OfferJpaRepository) : OfferRepositoryPort,
    BaseRepositoryImpl<Offer>(repository)

@Repository
private class OrderListRepositoryAdapter(repository: OrderListJpaRepository) : OrderListRepositoryPort,
    BaseRepositoryImpl<OrderList>(repository)