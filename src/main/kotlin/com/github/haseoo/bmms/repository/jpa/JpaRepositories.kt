package com.github.haseoo.bmms.repository.jpa

import com.github.haseoo.bmms.domain.Company
import com.github.haseoo.bmms.domain.Material
import com.github.haseoo.bmms.domain.Offer
import com.github.haseoo.bmms.domain.OrderList
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyJpaRepository : JpaRepository<Company, Long>

interface MaterialJpaRepository : JpaRepository<Material, Long>

interface OrderListJpaRepository : JpaRepository<OrderList, Long>

interface OfferJpaRepository : JpaRepository<Offer, Long>