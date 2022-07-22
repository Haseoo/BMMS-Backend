package com.github.haseoo.bmms.repository.port

import com.github.haseoo.bmms.repository.adapter.BaseRepository
import com.github.haseoo.bmms.util.unwrap
import org.springframework.data.jpa.repository.JpaRepository

abstract class BaseRepositoryImpl<T : Any>(private val repository: JpaRepository<T, Long>) :
    BaseRepository<T> {

    override fun findAll(): Collection<T> = repository.findAll()

    override fun findById(id: Long): T? = repository.findById(id).unwrap()

    override fun delete(entity: T) = repository.delete(entity)

    override fun save(entity: T) = repository.save(entity)
}