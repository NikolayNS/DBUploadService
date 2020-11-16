package com.dmitrenko.dbuploadservice.service.datasource.domain

import com.dmitrenko.dbuploadservice.domain.datasourse.DataSource
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceAddRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceUpdateRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DataSourceDomainService {
    fun add(request: DataSourceAddRequest): Mono<DataSource>
    fun get(request: DataSourceRequest): Mono<DataSource>
    fun getAll(): Flux<DataSource>
    fun update(request: DataSourceUpdateRequest): Mono<DataSource>
    fun delete(request: DataSourceRequest): Mono<Void>
}