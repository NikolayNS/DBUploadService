package com.dmitrenko.dbuploadservice.domain.task

enum class TaskStatusEnum {
	IDLE,
	ACTIVE,
	FINISHED,
	ERORR;

	companion object {
		fun getStatusByName(name: String) = valueOf(name.toUpperCase())
	}
}