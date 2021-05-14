package com.example.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ProducerConsumerWithSpringApplication

fun main(args: Array<String>) {
	runApplication<ProducerConsumerWithSpringApplication>(*args)
}

