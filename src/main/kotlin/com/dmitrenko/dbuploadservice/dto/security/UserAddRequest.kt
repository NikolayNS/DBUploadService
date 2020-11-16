package com.dmitrenko.dbuploadservice.dto.security

data class UserAddRequest(
		var statusId: Long,
		var name: String,
		var email: String
)