package com.dmitrenko.dbuploadservice.service.security.impl

import com.dmitrenko.dbuploadservice.domain.security.Role
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import com.dmitrenko.dbuploadservice.dto.security.UserRoleRequest
import com.dmitrenko.dbuploadservice.service.security.UserRoleService
import com.dmitrenko.dbuploadservice.service.security.domain.UserRoleDomainService

@Service
class UserRoleServiceImpl(
		private val domainService: UserRoleDomainService
): UserRoleService {

	override fun addAll(request: UserRoleRequest) =
			domainService.addAll(request.roleIds
					.toFlux()
					.flatMap { Pair(request.userId, it).toMono() })

	override fun deleteAll(request: UserRoleRequest) =
			domainService.deleteAll(Pair(request.userId, request.roleIds))

	override fun getAll(userId: Long): Flux<Role> = domainService.getAll(userId)
}