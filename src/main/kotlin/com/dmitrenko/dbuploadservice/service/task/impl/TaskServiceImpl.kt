package com.dmitrenko.dbuploadservice.service.task.impl

import com.dmitrenko.dbuploadservice.domain.task.Task
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest
import com.dmitrenko.dbuploadservice.dto.task.TaskRequest
import com.dmitrenko.dbuploadservice.service.task.domain.TaskDomainService
import com.dmitrenko.dbuploadservice.service.task.TaskService
import com.dmitrenko.dbuploadservice.service.task.domain.TaskSettingsDomainService

@Service
class TaskServiceImpl(
        private val domainService: TaskDomainService,
        private val taskSettingsDomainService: TaskSettingsDomainService
): TaskService {

    override fun add(request: TaskAddRequest, file: Mono<FilePart>): Mono<Task> =
            file
                    .flatMap {
                        domainService.add(request, taskSettingsDomainService.add(request, file))
                    }

    override fun get(request: TaskRequest): Mono<Task> =
            domainService.get(request.id)

    override fun getAllUserTask(request: UserRequest): Flux<Task> =
        domainService.getAllUserTask(request.id)

    override fun cancel(request: TaskRequest): Mono<Void> {
        TODO("Not yet implemented")
    }
}