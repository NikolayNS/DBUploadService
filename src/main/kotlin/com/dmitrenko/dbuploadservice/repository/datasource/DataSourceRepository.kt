package com.dmitrenko.dbuploadservice.repository.datasource

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.domain.datasourse.DataSource

interface DataSourceRepository : ReactiveCrudRepository<DataSource, Long> {

    @Modifying
    @Query("UPDATE REPOSITORY.DATA_SOURCE SET TYPE_ID=:typeId, URL=:url, USER_NAME=:userName, PASSWORD=:password, MODIFIED=CURRENT_TIMESTAMP() WHERE DATA_SOURCE_ID=:id")
    fun update(id: Long, typeId: Long, url: String, userName: String, password: String): Mono<Long>
}