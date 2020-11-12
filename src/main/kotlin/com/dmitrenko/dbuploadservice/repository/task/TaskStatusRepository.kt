package com.dmitrenko.dbuploadservice.repository.task

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import com.dmitrenko.dbuploadservice.domain.task.TaskStatus

interface TaskStatusRepository : ReactiveCrudRepository<TaskStatus, Long> {
}