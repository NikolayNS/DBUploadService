package com.dmitrenko.dbuploadservice.domain.task

enum class TaskStatusEnum {
	IDLE,
	ACTIVE,
	FINISHED,
	CANCELING,
	ERROR;

	companion object {
		fun getStatusByName(name: String) = valueOf(name.toUpperCase())
	}
}