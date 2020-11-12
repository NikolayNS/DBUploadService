package com.dmitrenko.dbuploadservice.repository.security

import com.dmitrenko.dbuploadservice.domain.security.UserRole
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface UserRoleRepository : ReactiveCrudRepository<UserRole, Long> {
	fun findAllByUserId(userId: Long): Flux<UserRole>
}