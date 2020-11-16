package com.dmitrenko.dbuploadservice.service.security

import com.dmitrenko.dbuploadservice.domain.security.Role
import com.dmitrenko.dbuploadservice.domain.security.UserRole
import com.dmitrenko.dbuploadservice.dto.security.UserRoleRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserRoleService {
	fun addAll(request: UserRoleRequest): Flux<UserRole>
	fun deleteAll(request: UserRoleRequest): Mono<Void>
	fun getAll(userId: Long): Flux<Role>
}