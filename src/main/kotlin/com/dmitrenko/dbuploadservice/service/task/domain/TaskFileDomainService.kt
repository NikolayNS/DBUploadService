package com.dmitrenko.dbuploadservice.service.task.domain

import org.springframework.http.codec.multipart.FilePart
import reactor.core.publisher.Mono

interface TaskFileDomainService {
    fun save(file: Mono<FilePart>): Mono<String>
}