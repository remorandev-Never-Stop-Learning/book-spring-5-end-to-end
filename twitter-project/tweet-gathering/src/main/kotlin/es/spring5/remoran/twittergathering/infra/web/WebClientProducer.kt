package es.spring5.remoran.twittergathering.infra.web

import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient

open class WebClientProducer {

    @Bean
    open fun webClient(): WebClient? {
        return WebClient.create();
    }
}