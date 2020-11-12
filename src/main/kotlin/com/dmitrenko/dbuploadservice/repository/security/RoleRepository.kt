package com.dmitrenko.dbuploadservice.repository.security

import com.dmitrenko.dbuploadservice.domain.security.Role
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface RoleRepository : ReactiveCrudRepository<Role, Long> {

	fun findByName(name: String): Mono<Role>

	@Modifying
	@Query("UPDATE REPOSITORY.ROLE SET NAME=:name, DESCRIPTION=:description WHERE ROLE_ID=:id")
	fun update(id: Long, name: String, description: String): Mono<Long>
}