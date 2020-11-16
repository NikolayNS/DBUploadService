package com.dmitrenko.dbuploadservice.service.security.domain

import com.dmitrenko.dbuploadservice.domain.security.User
import com.dmitrenko.dbuploadservice.dto.security.UserAddRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.security.UserUpdateRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserDomainService {
	fun add(request: UserAddRequest): Mono<User>
	fun get(request: UserRequest): Mono<User>
	fun getAll(): Flux<User>
	fun update(request: UserUpdateRequest): Mono<User>
	fun delete(request: UserRequest): Mono<Void>
	fun findByName(name: String): Mono<User>
}