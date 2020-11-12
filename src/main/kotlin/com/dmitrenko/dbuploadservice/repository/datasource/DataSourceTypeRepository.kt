package com.dmitrenko.dbuploadservice.repository.datasource

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import com.dmitrenko.dbuploadservice.domain.datasourse.DataSourceType

interface DataSourceTypeRepository: ReactiveCrudRepository<DataSourceType, Long> {
}