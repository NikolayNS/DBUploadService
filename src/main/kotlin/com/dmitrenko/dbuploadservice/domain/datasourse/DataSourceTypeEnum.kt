package com.dmitrenko.dbuploadservice.domain.datasourse

enum class DataSourceTypeEnum {
	POSTGRESQL,
	POSTGRESQL_TEST,
	HADOOP;

	companion object {
		fun getTypeByName(name: String) = valueOf(name.toUpperCase())
	}
}