package com.dmitrenko.dbuploadservice.service.security.impl

import com.dmitrenko.dbuploadservice.domain.security.Role
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.dto.security.RoleAddRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleUpdateRequest
import com.dmitrenko.dbuploadservice.service.security.RoleService
import com.dmitrenko.dbuploadservice.service.security.domain.RoleDomainService

@Service
class RoleServiceImpl(
		private val domainService: RoleDomainService
) : RoleService {

	override fun add(request: RoleAddRequest): Mono<Role> = domainService.add(request)

	override fun get(request: RoleRequest): Mono<Role> = domainService.get(request)

	override fun getAll(): Flux<Role> = domainService.getAll()

	override fun update(request: RoleUpdateRequest): Mono<Role> = domainService.update(request)

	override fun delete(request: RoleRequest): Mono<Void> = domainService.delete(request)
}