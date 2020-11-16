package com.dmitrenko.dbuploadservice.service.datasource.impl

import com.dmitrenko.dbuploadservice.domain.datasourse.DataSource
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceAddRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceUpdateRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.service.datasource.DataSourceService
import com.dmitrenko.dbuploadservice.service.datasource.domain.DataSourceDomainService

@Service
class DataSourceServiceImpl(
        private val domainService: DataSourceDomainService
) : DataSourceService {

    override fun add(request: DataSourceAddRequest): Mono<DataSource> =
            domainService.add(request)

    override fun get(request: DataSourceRequest): Mono<DataSource> =
            domainService.get(request)

    override fun getAll(): Flux<DataSource> =
            domainService.getAll()

    override fun update(request: DataSourceUpdateRequest): Mono<DataSource> =
            domainService.update(request)

    override fun delete(request: DataSourceRequest): Mono<Void> =
            domainService.delete(request)
}