package com.dmitrenko.dbuploadservice.dto.datasource

data class DataSourceAddRequest(
        val typeId: Long,
        val url: String,
        val userName: String,
        val password: String
)