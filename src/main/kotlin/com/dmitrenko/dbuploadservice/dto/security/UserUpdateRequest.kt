package com.dmitrenko.dbuploadservice.dto.security

data class UserUpdateRequest(
		var id: Long,
		var statusId: Long,
		var name: String,
		var email: String
)