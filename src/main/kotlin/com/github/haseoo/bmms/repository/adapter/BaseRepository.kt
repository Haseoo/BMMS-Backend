package com.github.haseoo.bmms.repository.adapter

interface BaseRepository<T> {

    fun findAll(): Collection<T>

    fun findById(id: Long): T?

    fun save(entity: T): T

    fun delete(entity: T)
}