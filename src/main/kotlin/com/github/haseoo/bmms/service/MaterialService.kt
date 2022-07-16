package com.github.haseoo.bmms.service

import com.github.haseoo.bmms.domain.Material

interface MaterialService {

    fun findAllMaterials(): Collection<Material>

    fun findMaterialById(id: Long): Material

    fun addMaterial(material: Material): Material

    fun updateMaterial(material: Material): Material

    fun removeMaterialById(materialId: Long)
}