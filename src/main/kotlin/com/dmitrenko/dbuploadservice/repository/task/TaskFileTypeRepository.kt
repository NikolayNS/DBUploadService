package com.dmitrenko.dbuploadservice.repository.task

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import com.dmitrenko.dbuploadservice.domain.task.TaskFileType

interface TaskFileTypeRepository : ReactiveCrudRepository<TaskFileType, Long> {
}