package com.posc.config;


import com.posc.repository.model.DailyAggregateData;
import com.posc.repository.redis.DailyAggregateDataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.List;

import static java.util.Arrays.asList;

@Configuration
@EnableRedisRepositories(basePackageClasses = DailyAggregateDataRepository.class)
public class RedisConfiguration {

  @Value("${spring.redis.cluster.nodes}")
  private String redisHosts;

  @Bean
  public RedisTemplate<String, DailyAggregateData> redisTemplate() {
    RedisTemplate<String, DailyAggregateData> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(lettuceConnectionFactory());
    redisTemplate.setEnableTransactionSupport(true);
    return redisTemplate;
  }
  /**
   * lettuce
   */
  @Bean
  public RedisConnectionFactory lettuceConnectionFactory() {
    RedisClusterConfiguration sentinelConfig = new RedisClusterConfiguration(asList(redisHosts.split(",")));

    return new LettuceConnectionFactory(sentinelConfig);
  }
}
