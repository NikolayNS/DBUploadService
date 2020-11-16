package com.dmitrenko.dbuploadservice.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.domain.datasourse.DataSource
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceAddRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceUpdateRequest
import com.dmitrenko.dbuploadservice.service.datasource.DataSourceService

const val DATA_SOURCE_ADD = "api/v1/security/datasource/add"
const val DATA_SOURCE_GET = "api/v1/security/datasource/get"
const val DATA_SOURCE_GET_ALL = "api/v1/security/datasource/get-all"
const val DATA_SOURCE_UPDATE = "api/v1/security/datasource/update"
const val DATA_SOURCE_DELETE = "api/v1/security/datasource/delete"

@RestController
class DataSourceController(
        private val service: DataSourceService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(DATA_SOURCE_ADD)
    fun add(@RequestBody request: DataSourceAddRequest): Mono<DataSource> = service.add(request)

    @PostMapping(DATA_SOURCE_GET)
    fun get(@RequestBody request: DataSourceRequest): Mono<DataSource> = service.get(request)

    @PostMapping(DATA_SOURCE_GET_ALL)
    fun getAll(): Flux<DataSource> = service.getAll()

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(DATA_SOURCE_UPDATE)
    fun update(@RequestBody request: DataSourceUpdateRequest): Mono<DataSource> = service.update(request)

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(DATA_SOURCE_DELETE)
    fun delete(@RequestBody request: DataSourceRequest): Mono<Void> = service.delete(request)
}