package com.dmitrenko.dbuploadservice.repository.task

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import com.dmitrenko.dbuploadservice.domain.task.TaskSettings

interface TaskSettingsRepository: ReactiveCrudRepository<TaskSettings, Long> {
}