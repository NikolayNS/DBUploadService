package com.dmitrenko.dbuploadservice.domain.security

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("REPOSITORY.USER")
data class User(

		@Column("USER_STATUS_ID")
		var statusId: Long,

		@Column("NAME")
		var name: String,

		@Column("EMAIL")
		var email: String,

		@Column("CREATED")
		var created: LocalDateTime = LocalDateTime.now(),

		@Column("MODIFIED")
		var modified: LocalDateTime = LocalDateTime.now(),
) {
	@Id
	@Column("USER_ID")
	var id: Long? = null

	@Transient
	var roles: Set<Role> = mutableSetOf()
}