package com.dmitrenko.dbuploadservice.dto.datasource

data class DataSourceUpdateRequest(
        val id: Long,
        val typeId: Long,
        val url: String,
        val userName: String,
        val password: String
)