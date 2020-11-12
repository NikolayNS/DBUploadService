package com.dmitrenko.dbuploadservice.domain.task

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("REPOSITORY.TASK_SETTINGS")
class TaskSettings(

		@Column("TASK_FILE_TYPE_ID")
		var taskFileTypeId: Long,

		@Column("PATH_NAME")
		var pathName: String,

		@Column("TABLE_NAME")
		var tableName: String
){
	@Id
	@Column("TASK_SETTINGS_ID")
	var id: Long? = null
}