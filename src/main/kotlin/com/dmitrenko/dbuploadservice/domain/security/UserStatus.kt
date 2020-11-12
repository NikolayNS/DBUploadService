package com.dmitrenko.dbuploadservice.domain.security

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.USER_STATUS")
data class UserStatus(

		@Column("NAME")
		var name: String,

		@Column("DESCRIPTION")
		var description: String
){
	@Id
	@Column("USER_STATUS_ID")
	var id: Long? = null
}