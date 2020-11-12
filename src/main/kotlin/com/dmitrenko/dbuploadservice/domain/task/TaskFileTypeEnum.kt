package com.dmitrenko.dbuploadservice.domain.task

enum class TaskFileTypeEnum {
	CSV,
	XLSX,
	JSON,
	AVRO,
	XML;

	companion object {
		fun getTypeByName(name: String) = valueOf(name.toUpperCase())
	}
}