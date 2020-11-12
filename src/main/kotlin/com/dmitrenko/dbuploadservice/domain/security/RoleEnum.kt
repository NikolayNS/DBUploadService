package com.dmitrenko.dbuploadservice.domain.security

enum class RoleEnum {
	ADMIN,
	USER;

	companion object {
		fun getRoleByName(name: String) = valueOf(name.toUpperCase())
	}
}