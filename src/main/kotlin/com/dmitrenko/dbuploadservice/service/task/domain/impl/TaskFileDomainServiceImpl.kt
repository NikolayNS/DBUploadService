package com.dmitrenko.dbuploadservice.service.task.domain.impl

import com.dmitrenko.dbuploadservice.service.task.domain.TaskFileDomainService
import com.dmitrenko.dbuploadservice.utils.ISO_DATE_TIME_PATTERN
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.nio.file.Path
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class TaskFileDomainServiceImpl: TaskFileDomainService {

    @Value("\${task.file.folder}")
    private lateinit var taskFileFolder: String

    override fun save(file: Mono<FilePart>): Mono<String> {
        val path = "${taskFileFolder}UserName_${LocalDateTime.now().format(DateTimeFormatter.ofPattern(ISO_DATE_TIME_PATTERN))}"
        return file
                .flatMap { it.transferTo(Path.of("${path}.${it.filename().split(".").last()}")) }
                .then(Mono.just(path))
    }
}