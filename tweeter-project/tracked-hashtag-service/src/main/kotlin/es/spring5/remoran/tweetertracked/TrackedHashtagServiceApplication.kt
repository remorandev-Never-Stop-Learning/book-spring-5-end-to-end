package es.spring5.remoran.tweetertracked

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrackedHashtagServiceApplication

fun main(args: Array<String>) {
    runApplication<TrackedHashtagServiceApplication>(*args)
}
