package com.dmitrenko.dbuploadservice.domain.task

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.TASK_STATUS")
class TaskStatus(

		@Column("NAME")
		var name: String,

		@Column("DESCRIPTION")
		var description: String
){
	@Id
	@Column("TASK_STATUS_ID")
	var id: Long? = null
}