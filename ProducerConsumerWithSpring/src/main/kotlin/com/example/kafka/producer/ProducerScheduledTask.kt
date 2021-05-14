package com.example.kafka.producer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*

@Component
class ProducerScheduledTask(private val producer: Producer) {

    private val log: Logger = LoggerFactory.getLogger(ProducerScheduledTask::class.java)
    private val dateFormat = SimpleDateFormat("HH:mm:ss")

    @Scheduled(fixedRate = 100)
    fun reportCurrentTimeMessage() {
        producer.postMessage("message ${dateFormat.format(Date())}")
    }
}