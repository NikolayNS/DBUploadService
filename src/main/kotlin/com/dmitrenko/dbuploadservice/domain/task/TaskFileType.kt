package com.dmitrenko.dbuploadservice.domain.task

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.TASK_SETTINGS_TYPE")
class TaskFileType(

		@Column("NAME")
		var name: String,

		@Column("DESCRIPTION")
		var description: String
){
	@Id
	@Column("TASK_FILE_TYPE_ID")
	var id: Long? = null
}