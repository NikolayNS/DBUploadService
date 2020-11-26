package com.dmitrenko.dbuploadservice.service.task.domain.impl

import com.dmitrenko.dbuploadservice.domain.task.TaskFileTypeEnum
import com.dmitrenko.dbuploadservice.domain.task.TaskSettings
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest
import com.dmitrenko.dbuploadservice.repository.task.TaskSettingsRepository
import com.dmitrenko.dbuploadservice.service.task.domain.TaskFileDomainService
import com.dmitrenko.dbuploadservice.service.task.domain.TaskSettingsDomainService
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TaskSettingsDomainServiceImpl(
        private val repository: TaskSettingsRepository,
        private val taskFileDomainService: TaskFileDomainService
) : TaskSettingsDomainService {

    override fun add(request: TaskAddRequest, file: Mono<FilePart>): Mono<TaskSettings> =
            file
                    .zipWith(taskFileDomainService.save(file))
                    .flatMap {tuple ->
                        repository.save(
                                TaskSettings(
                                        TaskFileTypeEnum.getTypeByName(tuple.t1.filename().split(".").last()).ordinal.toLong(),
                                        tuple.t2,
                                        request.tableName!!
                                )
                        )
                    }

    override fun get(id: Long): Mono<TaskSettings> = repository.findById(id)
}