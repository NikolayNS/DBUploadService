package com.dmitrenko.dbuploadservice.repository.security

import com.dmitrenko.dbuploadservice.domain.security.UserStatus
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserStatusRepository : ReactiveCrudRepository<UserStatus, Long> {
}