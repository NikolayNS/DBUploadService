package com.dmitrenko.dbuploadservice.service.security.domain.impl

import com.dmitrenko.dbuploadservice.domain.security.Role
import com.dmitrenko.dbuploadservice.dto.security.RoleAddRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleUpdateRequest
import com.dmitrenko.dbuploadservice.repository.security.RoleRepository
import com.dmitrenko.dbuploadservice.service.security.domain.RoleDomainService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RoleDomainServiceImpl(
		private val repository: RoleRepository
) : RoleDomainService {

	override fun add(request: RoleAddRequest): Mono<Role> =
			repository
					.findByName(request.name)
					.switchIfEmpty(repository.save(Role(request.name, request.description)))

	override fun get(request: RoleRequest): Mono<Role> = repository.findById(request.id)

	override fun getAll(): Flux<Role> = repository.findAll()

	override fun update(request: RoleUpdateRequest): Mono<Role> =
			repository
					.update(request.id, request.name, request.description)
					.flatMap { repository.findById(it) }

	override fun delete(request: RoleRequest): Mono<Void> = repository.deleteById(request.id)
}