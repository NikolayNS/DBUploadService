package com.dmitrenko.dbuploadservice.domain.security

enum class UserStatusEnum {
	DISABLED,
	ACTIVE,
	LOGGED_OFF;

	companion object {
		fun getStatusByName(name: String) = valueOf(name.toUpperCase())
	}
}