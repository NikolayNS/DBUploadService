package com.dmitrenko.dbuploadservice.dto.security

data class UserRoleRequest(
		var userId: Long,
		var roleIds: Set<Long> = mutableSetOf()
)