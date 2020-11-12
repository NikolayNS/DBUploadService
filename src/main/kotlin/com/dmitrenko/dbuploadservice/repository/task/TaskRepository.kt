package com.dmitrenko.dbuploadservice.repository.task

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import com.dmitrenko.dbuploadservice.domain.task.Task

interface TaskRepository : ReactiveCrudRepository<Task, Long> {
	fun findAllByUserId(userId: Long): Flux<Task>

	@Modifying
	@Query("UPDATE REPOSITORY.TASK SET STATUS_ID=:statusId, MODIFIED=CURRENT_TIMESTAMP() WHERE TASK_ID=:id")
	fun updateStatus(id: Long, statusId: Long): Mono<Long>
}