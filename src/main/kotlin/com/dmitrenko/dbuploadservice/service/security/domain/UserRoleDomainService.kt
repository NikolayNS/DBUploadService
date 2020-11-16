package com.dmitrenko.dbuploadservice.service.security.domain

import com.dmitrenko.dbuploadservice.domain.security.Role
import com.dmitrenko.dbuploadservice.domain.security.UserRole
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserRoleDomainService {
	fun addAll(userRolePair: Flux<Pair<Long, Long>>): Flux<UserRole>
	fun deleteAll(userRolePair: Pair<Long, Set<Long>>): Mono<Void>
	fun getAll(userId: Long): Flux<Role>
}
