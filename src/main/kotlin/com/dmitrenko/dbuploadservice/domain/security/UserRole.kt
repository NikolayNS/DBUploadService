package com.dmitrenko.dbuploadservice.domain.security

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.USER_ROLE")
data class UserRole(

		@Column("USER_ID")
		var userId: Long,

		@Column("ROLE_ID")
		var roleId: Long,
){
	@Id
	@Column("USER_ROLE_ID")
	var id: Long? = null
}