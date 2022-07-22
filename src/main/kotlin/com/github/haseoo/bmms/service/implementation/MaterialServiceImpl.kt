package com.github.haseoo.bmms.service.implementation

import com.github.haseoo.bmms.domain.Material
import com.github.haseoo.bmms.exception.NotFoundException
import com.github.haseoo.bmms.repository.adapter.MaterialRepositoryPort
import com.github.haseoo.bmms.service.MaterialService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class MaterialServiceImpl
    (
    private val materialRepository: MaterialRepositoryPort
) : MaterialService {
    override fun findAllMaterials(): Collection<Material> = materialRepository.findAll()

    override fun getMaterialById(id: Long): Material =
        materialRepository.findById(id) ?: throw NotFoundException("Material", id)

    @Transactional
    override fun addMaterial(material: Material): Material = materialRepository.save(material)

    override fun updateMaterial(material: Material): Material {
        val existingMaterial = getMaterialById(material.id!!)
        existingMaterial.specification = material.specification
        return materialRepository.save(existingMaterial)
    }

    @Transactional
    override fun removeMaterialById(materialId: Long) = materialRepository.delete(getMaterialById(materialId))
}