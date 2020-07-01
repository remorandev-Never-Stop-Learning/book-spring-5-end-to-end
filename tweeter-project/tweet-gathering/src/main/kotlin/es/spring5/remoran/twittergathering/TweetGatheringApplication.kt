package es.spring5.remoran.twittergathering

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.runApplication

@SpringBootConfiguration
class TwetterGatheringApplication

fun main(args: Array<String>) {
    runApplication<TwetterGatheringApplication>(*args)
}