package com.example.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class Producer(private val kafkaTemplate: KafkaTemplate<Int, String>) {

    fun postMessage(message: String) {
        kafkaTemplate.send("topic",message)
    }

}