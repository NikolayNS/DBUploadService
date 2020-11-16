package com.dmitrenko.dbuploadservice.controller

import com.dmitrenko.dbuploadservice.domain.security.User
import com.dmitrenko.dbuploadservice.dto.security.UserAddRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.security.UserRoleRequest
import com.dmitrenko.dbuploadservice.dto.security.UserUpdateRequest
import com.dmitrenko.dbuploadservice.service.security.UserService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

const val USER_ADD = "api/v1/security/user/add"
const val USER_GET = "api/v1/security/user/get"
const val USER_GET_ALL = "api/v1/security/user/get-all"
const val USER_UPDATE = "api/v1/security/user/update"
const val USER_DELETE = "api/v1/security/user/delete"
const val USER_ADD_ROLE = "api/v1/security/user/add-role"
const val USER_DELETE_ROLE = "api/v1/security/user/delete-role"

@RestController
class UserController(
		private val service: UserService
) {

	@ResponseStatus(CREATED)
	@PostMapping(USER_ADD)
	fun add(@RequestBody request: UserAddRequest): Mono<User> = service.add(request)

	@PostMapping(USER_GET)
	fun get(@RequestBody request: UserRequest): Mono<User> = service.get(request)

	@PostMapping(USER_GET_ALL)
	fun getAll(): Flux<User> = service.getAll()

	@ResponseStatus(OK)
	@PostMapping(USER_UPDATE)
	fun update(@RequestBody request: UserUpdateRequest): Mono<User> = service.update(request)

	@ResponseStatus(NO_CONTENT)
	@PostMapping(USER_DELETE)
	fun delete(@RequestBody request: UserRequest): Mono<Void> = service.delete(request)

	@ResponseStatus(OK)
	@PostMapping(USER_ADD_ROLE)
	fun addRole(@RequestBody request: UserRoleRequest): Mono<User> = service.addRole(request)

	@ResponseStatus(OK)
	@PostMapping(USER_DELETE_ROLE)
	fun deleteRole(@RequestBody request: UserRoleRequest): Mono<User> = service.deleteRole(request)
}

