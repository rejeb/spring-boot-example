package com.posc.repository.redis;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.sync.RedisStringCommands;
import org.junit.Test;

public class DailyAggregateDataRepositoryTest {

  @Test
  public void test(){
    RedisClient client = RedisClient.create("redis://localhost:6379");
    StatefulRedisConnection<String, String> connection = client.connect();
    RedisStringCommands sync = connection.sync();
    String value = sync.set("test","testala");
  }
}
