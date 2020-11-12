package com.dmitrenko.dbuploadservice.domain.datasourse

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.DATA_SOURCE_TYPE")
data class DataSourceType(

		@Column("NAME")
		var name: String,

		@Column("DESCRIPTION")
		var description: String
){
	@Id
	@Column("DATA_SOURCE_TYPE_ID")
	var id: Long? = null
}