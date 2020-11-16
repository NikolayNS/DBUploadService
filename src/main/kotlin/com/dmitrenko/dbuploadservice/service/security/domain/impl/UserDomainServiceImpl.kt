package com.dmitrenko.dbuploadservice.service.security.domain.impl

import com.dmitrenko.dbuploadservice.domain.security.User
import com.dmitrenko.dbuploadservice.domain.security.UserStatusEnum.ACTIVE
import com.dmitrenko.dbuploadservice.dto.security.UserAddRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.security.UserUpdateRequest
import com.dmitrenko.dbuploadservice.repository.security.UserRepository
import com.dmitrenko.dbuploadservice.service.security.domain.UserDomainService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserDomainServiceImpl(
		private val repository: UserRepository,
) : UserDomainService {

	override fun add(request: UserAddRequest): Mono<User> =
			repository
					.findByName(request.name)
					.switchIfEmpty(repository.save(User(ACTIVE.ordinal.toLong(), request.name, request.email)))

	override fun get(request: UserRequest): Mono<User> = repository.findById(request.id)

	override fun getAll(): Flux<User> = repository.findAll()

	override fun update(request: UserUpdateRequest): Mono<User> =
			repository
					.update(request.id, request.statusId, request.name, request.email)
					.flatMap { repository.findById(it) }

	override fun delete(request: UserRequest): Mono<Void> = repository.deleteById(request.id)

	override fun findByName(name: String): Mono<User> = repository.findByName(name)
}

