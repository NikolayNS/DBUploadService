package com.dmitrenko.dbuploadservice.service.task.domain

import com.dmitrenko.dbuploadservice.domain.task.TaskSettings
import org.springframework.http.codec.multipart.FilePart
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest

interface TaskSettingsDomainService {
    fun add(request: TaskAddRequest, file: Mono<FilePart>): Mono<TaskSettings>
    fun get(id: Long): Mono<TaskSettings>
}