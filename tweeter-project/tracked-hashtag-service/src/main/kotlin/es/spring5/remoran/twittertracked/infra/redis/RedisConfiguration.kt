package es.spring5.remoran.twittertracked.infra.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.RedisSerializationContext

@Configuration
class RedisConfiguration {

    @Bean
    fun reactiveRedisTemplate(connectionfactory:ReactiveRedisConnectionFactory):ReactiveRedisTemplate<String, String> {
        return ReactiveRedisTemplate(connectionfactory, RedisSerializationContext.string())
    }
}