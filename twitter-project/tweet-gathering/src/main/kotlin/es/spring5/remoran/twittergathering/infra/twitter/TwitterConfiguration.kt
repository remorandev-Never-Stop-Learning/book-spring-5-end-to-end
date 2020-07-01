package es.spring5.remoran.twittergathering.infra.twitter

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TwitterConfiguration(@Value("\${twitter.consumer-key}") private val consumerKey: String,
                                @Value("\${twitter.consumer-secret}") private val consumerSecret: String,
                                @Value("\${twitter.access-token}") private val accessToken: String,
                                @Value("\${twitter.access-token-secret}") private val accessTokenSecret: String) {

    @Bean
    fun twitterAppSettings(): Twitter.TwitterAppSettings {
        return Twitter.TwitterAppSettings(consumerKey, consumerSecret)
    }

    @Bean
    fun twitterToken(): Twitter.TwitterToken {
        return Twitter.TwitterToken(accessToken, accessTokenSecret)
    }
}