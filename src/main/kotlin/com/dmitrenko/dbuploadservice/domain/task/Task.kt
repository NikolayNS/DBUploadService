package com.dmitrenko.dbuploadservice.domain.task

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("REPOSITORY.TASK")
data class Task(

		@Column("USER_ID")
		var userId: Long,

		@Column("TASK_STATUS_ID")
		var statusId: Long,

		@Column("TASK_SETTINGS_ID")
		var settingsId: Long,

		@Column("DATA_SOURCE_ID")
		var dataSourceId: Long,

		@Column("CREATED")
		var created: LocalDateTime = LocalDateTime.now(),

		@Column("MODIFIED")
		var modified: LocalDateTime = LocalDateTime.now()
){
	@Id
	@Column("TASK_ID")
	var id: Long? = null
}