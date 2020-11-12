package com.dmitrenko.dbuploadservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DbUploadServiceApplication

fun main(args: Array<String>) {
	runApplication<DbUploadServiceApplication>(*args)
}
