package com.dmitrenko.dbuploadservice.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.domain.security.Role
import com.dmitrenko.dbuploadservice.dto.security.RoleAddRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleRequest
import com.dmitrenko.dbuploadservice.dto.security.RoleUpdateRequest
import com.dmitrenko.dbuploadservice.service.security.RoleService

const val ROLE_ADD = "api/v1/security/role/add"
const val ROLE_GET = "api/v1/security/role/get"
const val ROLE_GET_ALL = "api/v1/security/role/get-all"
const val ROLE_UPDATE = "api/v1/security/role/update"
const val ROLE_DELETE = "api/v1/security/role/delete"

@RestController
class RoleController(
		private val service: RoleService
) {

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(ROLE_ADD)
	fun add(@RequestBody request: RoleAddRequest): Mono<Role> = service.add(request)

	@PostMapping(ROLE_GET)
	fun get(@RequestBody request: RoleRequest): Mono<Role> = service.get(request)

	@PostMapping(ROLE_GET_ALL)
	fun getAll(): Flux<Role> = service.getAll()

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(ROLE_UPDATE)
	fun update(@RequestBody request: RoleUpdateRequest): Mono<Role> = service.update(request)

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(ROLE_DELETE)
	fun delete(@RequestBody request: RoleRequest): Mono<Void> = service.delete(request)
}