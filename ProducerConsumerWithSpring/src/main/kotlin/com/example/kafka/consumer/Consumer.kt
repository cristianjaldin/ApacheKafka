package com.example.kafka.consumer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Consumer {

    val log: Logger = LoggerFactory.getLogger(Consumer::class.java)

    @KafkaListener(topics = ["topic"], groupId ="group")
    fun listen(message:String) {
        log.info("Received Messasge in group:$message");
    }

}