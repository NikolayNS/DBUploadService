package com.dmitrenko.dbuploadservice.dto.task

data class TaskAddRequest(
        var userId: Long?,
        var dataSourceId: Long?,
        var tableName: String?
)