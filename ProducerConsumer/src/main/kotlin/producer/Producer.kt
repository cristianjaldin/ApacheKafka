package producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*

fun main(args: Array<String>) {

    val props = Properties()
    props["bootstrap.servers"] = "localhost:9092"
    props["acks"] = "1"
    props["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    props["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"

    KafkaProducer<Any?, Any?>(props).use { producer ->
        var i = 0
        while (i < 100) {
            producer.send(ProducerRecord("topic", "key", "message $i"))
            i++
        }
        producer.flush()
    }
}
