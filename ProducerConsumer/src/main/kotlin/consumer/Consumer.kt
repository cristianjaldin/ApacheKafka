package consumer

import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory
import java.time.Duration
import java.util.*


fun main(args: Array<String>) {

    val log = LoggerFactory.getLogger("logger consumer")

    val props = Properties()
    props.setProperty("bootstrap.servers", "localhost:9092")
    props.setProperty("group.id", "devs4j-group")
    props.setProperty("enable.auto.commit", "true")
    props.setProperty("auto.commit.interval.ms", "1000")
    props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    KafkaConsumer<String, String>(props).use { consumer ->
        consumer.subscribe(listOf("topic"))
        while (true) {
            val records: ConsumerRecords<String?, String?> = consumer.poll(Duration.ofMillis(100))
            for (record in records) log.info(
                "offset = {}, key = {}, value ={}",
                record.offset(), record.key(), record.value()
            )
        }
    }
}