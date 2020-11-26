package com.dmitrenko.dbuploadservice.service.task.domain.impl

import com.dmitrenko.dbuploadservice.domain.task.Task
import com.dmitrenko.dbuploadservice.domain.task.TaskSettings
import com.dmitrenko.dbuploadservice.domain.task.TaskStatusEnum
import com.dmitrenko.dbuploadservice.domain.task.TaskStatusEnum.IDLE
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest
import com.dmitrenko.dbuploadservice.repository.task.TaskRepository
import com.dmitrenko.dbuploadservice.service.task.domain.TaskDomainService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TaskDomainServiceImpl(
        private val repository: TaskRepository
) : TaskDomainService {

    override fun add(request: TaskAddRequest, settings: Mono<TaskSettings>): Mono<Task> =
            settings
                    .flatMap {
                        repository.save(
                                Task(request.userId!!, IDLE.ordinal.toLong(), it.id!!, request.dataSourceId!!)
                        )
                    }

    override fun get(id: Long): Mono<Task> = repository.findById(id)

    override fun getAllUserTask(userId: Long): Flux<Task> = repository.findAllByUserId(userId)

    override fun updateStatus(id: Long, status: TaskStatusEnum): Mono<Task> =
            repository
                    .updateStatus(id, status.ordinal.toLong())
                    .flatMap { repository.findById(it) }

    override fun findAllByStatus(status: TaskStatusEnum): Flux<Task> =
            repository.findAllByStatusId(status.ordinal.toLong())
}