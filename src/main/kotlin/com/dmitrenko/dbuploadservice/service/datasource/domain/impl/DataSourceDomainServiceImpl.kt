package com.dmitrenko.dbuploadservice.service.datasource.domain.impl

import com.dmitrenko.dbuploadservice.domain.datasourse.DataSource
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceAddRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceRequest
import com.dmitrenko.dbuploadservice.dto.datasource.DataSourceUpdateRequest
import com.dmitrenko.dbuploadservice.repository.datasource.DataSourceRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.service.datasource.domain.DataSourceDomainService

@Service
class DataSourceDomainServiceImpl(
        private val repository: DataSourceRepository
) : DataSourceDomainService {

    override fun add(request: DataSourceAddRequest): Mono<DataSource> =
            repository.save(DataSource(request.typeId, request.url, request.userName, request.password))

    override fun get(request: DataSourceRequest): Mono<DataSource> =
            repository.findById(request.id)

    override fun getAll(): Flux<DataSource> =
            repository.findAll()

    override fun update(request: DataSourceUpdateRequest): Mono<DataSource> =
            repository
                    .update(request.id, request.typeId, request.url, request.userName, request.password)
                    .flatMap { repository.findById(it) }

    override fun delete(request: DataSourceRequest): Mono<Void> =
            repository.deleteById(request.id)
}