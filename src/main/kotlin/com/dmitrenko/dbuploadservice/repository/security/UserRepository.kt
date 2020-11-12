package com.dmitrenko.dbuploadservice.repository.security

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.domain.security.User

interface UserRepository : ReactiveCrudRepository<User, Long> {

	fun findByName(name: String): Mono<User>

	@Modifying
	@Query("UPDATE REPOSITORY.USER SET USER_STATUS_ID=:statusId, NAME=:name, EMAIL=:email, MODIFIED=CURRENT_TIMESTAMP() WHERE USER_ID=:id")
	fun update(id: Long, statusId: Long, name: String, email: String): Mono<Long>
}