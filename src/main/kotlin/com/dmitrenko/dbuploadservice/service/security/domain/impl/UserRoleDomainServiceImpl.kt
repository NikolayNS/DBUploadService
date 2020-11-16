package com.dmitrenko.dbuploadservice.service.security.domain.impl

import com.dmitrenko.dbuploadservice.domain.security.Role
import com.dmitrenko.dbuploadservice.domain.security.UserRole
import com.dmitrenko.dbuploadservice.repository.security.RoleRepository
import com.dmitrenko.dbuploadservice.repository.security.UserRoleRepository
import com.dmitrenko.dbuploadservice.service.security.domain.UserRoleDomainService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class UserRoleDomainServiceImpl(
		private val repository: UserRoleRepository,
		private val roleRepository: RoleRepository
) : UserRoleDomainService {

	override fun addAll(userRolePair: Flux<Pair<Long, Long>>): Flux<UserRole> =
			userRolePair
					.flatMap {
						repository.save(UserRole(it.first, it.second))
					}

	override fun deleteAll(userRolePair: Pair<Long, Set<Long>>): Mono<Void> =
			repository.findAllByUserId(userRolePair.first)
					.flatMap {
						Mono.just(it)
								.filter { userRole -> userRolePair.second.contains(userRole.roleId)}
								.flatMap { userRole -> repository.deleteById(userRole.id!!) }
					}
					.toMono()

	override fun getAll(userId: Long): Flux<Role> {
		return repository
				.findAllByUserId(userId)
				.flatMap { userRole -> roleRepository.findById(userRole.roleId) }
	}
}