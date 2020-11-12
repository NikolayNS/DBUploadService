package com.dmitrenko.dbuploadservice.domain.datasourse

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("REPOSITORY.DATA_SOURCE")
data class DataSource(

		@Column("DATA_SOURCE_TYPE_ID")
		var typeId: Long,

		@Column("URL")
		var url: String,

		@Column("USER_NAME")
		var userName: String,

		@JsonIgnore
		@Column("PASSWORD")
		var password: String,

		@Column("CREATED")
		var created: LocalDateTime = LocalDateTime.now(),

		@Column("MODIFIED")
		var modified: LocalDateTime = LocalDateTime.now()
){
	@Id
	@Column("DATA_SOURCE_ID")
	var id: Long? = null
}