package com.dmitrenko.dbuploadservice.domain.security

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.ROLE")
data class Role(

		@Column("NAME")
		var name: String,

		@Column("DESCRIPTION")
		var description: String
){
	@Id
	@Column("ROLE_ID")
	var id: Long? = null
}