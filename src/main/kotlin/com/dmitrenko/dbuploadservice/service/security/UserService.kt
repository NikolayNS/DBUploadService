package com.dmitrenko.dbuploadservice.service.security

import com.dmitrenko.dbuploadservice.domain.security.User
import com.dmitrenko.dbuploadservice.dto.security.UserAddRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRoleRequest
import com.dmitrenko.dbuploadservice.dto.security.UserUpdateRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {
	fun add(request: UserAddRequest): Mono<User>
	fun get(request: UserRequest): Mono<User>
	fun getAll(): Flux<User>
	fun update(request: UserUpdateRequest): Mono<User>
	fun delete(request: UserRequest): Mono<Void>
	fun addRole(request: UserRoleRequest): Mono<User>
	fun deleteRole(request: UserRoleRequest): Mono<User>
}