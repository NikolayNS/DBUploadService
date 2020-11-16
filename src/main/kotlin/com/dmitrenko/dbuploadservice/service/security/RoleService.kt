package com.dmitrenko.dbuploadservice.service.security

import com.dmitrenko.dbuploadservice.domain.security.Role
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.dto.security.RoleAddRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleUpdateRequest

interface RoleService {
	fun add(request: RoleAddRequest): Mono<Role>
	fun get(request: RoleRequest): Mono<Role>
	fun getAll(): Flux<Role>
	fun update(request: RoleUpdateRequest): Mono<Role>
	fun delete(request: RoleRequest): Mono<Void>
}