package com.dmitrenko.dbuploadservice.service.security.impl

import com.dmitrenko.dbuploadservice.domain.security.User
import com.dmitrenko.dbuploadservice.dto.security.UserAddRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRoleRequest
import com.dmitrenko.dbuploadservice.dto.security.UserUpdateRequest
import com.dmitrenko.dbuploadservice.service.security.UserRoleService
import com.dmitrenko.dbuploadservice.service.security.UserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import com.dmitrenko.dbuploadservice.service.security.domain.UserDomainService

@Service
class UserServiceImpl(
		private val domainService: UserDomainService,
		private val userRoleService: UserRoleService
) : UserService {

	override fun add(request: UserAddRequest): Mono<User> =
			domainService.add(request)
					.flatMap { updateRole(it.id!!) }

	override fun get(request: UserRequest): Mono<User> =
			domainService.get(request)
					.flatMap { updateRole(it.id!!) }

	override fun getAll(): Flux<User> =
			domainService.getAll()
					.flatMap { updateRole(it.id!!) }

	override fun update(request: UserUpdateRequest): Mono<User> =
			domainService.update(request)
					.flatMap { updateRole(request.id) }

	override fun delete(request: UserRequest): Mono<Void> =
			domainService.delete(request)

	override fun addRole(request: UserRoleRequest): Mono<User> =
			userRoleService.addAll(request)
					.flatMap { updateRole(request.userId) }
					.toMono()

	override fun deleteRole(request: UserRoleRequest): Mono<User> =
			userRoleService.deleteAll(request)
					.flatMap { updateRole(request.userId) }

	private fun updateRole(userId: Long): Mono<User> {
		return domainService.get(UserRequest(userId))
				.flatMap { user ->
					Mono.just(user)
							.zipWith(userRoleService.getAll(user.id!!).collectList())
							.map { tuple ->
								tuple.t1.roles = tuple.t2.toSet()
								user
							}
				}
	}
}