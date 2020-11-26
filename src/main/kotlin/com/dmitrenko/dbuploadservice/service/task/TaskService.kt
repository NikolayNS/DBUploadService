package com.dmitrenko.dbuploadservice.service.task

import com.dmitrenko.dbuploadservice.domain.task.Task
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest
import com.dmitrenko.dbuploadservice.dto.task.TaskRequest
import org.springframework.http.codec.multipart.FilePart
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TaskService {
    fun add(request: TaskAddRequest, file: Mono<FilePart>): Mono<Task>
    fun get(request: TaskRequest): Mono<Task>
    fun getAllUserTask(request: UserRequest): Flux<Task>
    fun cancel(request: TaskRequest): Mono<Boolean>

    fun getAllIdleTask(): Flux<Task>
}