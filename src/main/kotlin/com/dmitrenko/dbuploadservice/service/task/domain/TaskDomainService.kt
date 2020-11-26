package com.dmitrenko.dbuploadservice.service.task.domain

import com.dmitrenko.dbuploadservice.domain.task.Task
import com.dmitrenko.dbuploadservice.domain.task.TaskSettings
import com.dmitrenko.dbuploadservice.domain.task.TaskStatusEnum
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest

interface TaskDomainService {
    fun add(request: TaskAddRequest, settings: Mono<TaskSettings>): Mono<Task>
    fun get(id: Long): Mono<Task>
    fun getAllUserTask(userId: Long): Flux<Task>
    fun updateStatus(id: Long, status: TaskStatusEnum): Mono<Task>

    fun findAllByStatus(status: TaskStatusEnum): Flux<Task>
}