package com.dmitrenko.dbuploadservice.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.domain.task.Task
import com.dmitrenko.dbuploadservice.dto.security.UserRequest
import com.dmitrenko.dbuploadservice.dto.task.TaskAddRequest
import com.dmitrenko.dbuploadservice.dto.task.TaskRequest
import com.dmitrenko.dbuploadservice.service.task.TaskService

const val TASK_ADD = "api/v1/task/add"
const val TASK_GET = "api/v1/task/get"
const val TASK_GET_ALL_BY_USER = "api/v1/task/get-all-by-user"
const val TASK_CANCEL = "api/v1/task/update"

@RestController
class TaskController(
        private val service: TaskService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(TASK_ADD, MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_STREAM_JSON_VALUE)
    fun add(@ModelAttribute request: TaskAddRequest, @RequestPart("file") file: Mono<FilePart>): Mono<Task> = service.add(request, file)

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(TASK_GET)
    fun get(@RequestBody request: TaskRequest): Mono<Task> = service.get(request)

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(TASK_GET_ALL_BY_USER)
    fun getAllUserTask(@RequestBody request: UserRequest): Flux<Task> = service.getAllUserTask(request)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(TASK_CANCEL)
    fun cancel(@RequestBody request: TaskRequest): Mono<Void> = service.cancel(request)
}