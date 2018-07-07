package com.posc.repository.redis;

import com.lambdaworks.redis.cluster.RedisClusterClient;
import com.lambdaworks.redis.cluster.api.StatefulRedisClusterConnection;
import com.lambdaworks.redis.cluster.api.sync.RedisClusterCommands;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Arrays.asList;

public class DailyAggregateDataRepositoryTest {

  // Syntax: redis://[password@]host[:port]

  RedisClusterClient redisClient1 = RedisClusterClient.create("redis://localhost:7001");
  RedisClusterClient redisClient2 = RedisClusterClient.create("redis://localhost:7001");

  StatefulRedisClusterConnection<String, String> clusterCommands1 = redisClient1.connect();
  StatefulRedisClusterConnection<String, String> clusterCommands2 = redisClient2.connect();



  @Test
  public void test() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    executor.invokeAll(asList(putDataWait(clusterCommands1.getConnection("127.0.0.1",7001).sync()),putData(clusterCommands2.getConnection("127.0.0.1",7001).sync())));

    Thread.sleep(4);
  }

  private Callable<String> putDataWait(RedisClusterCommands redisCommands) {
    return () -> {
      redisCommands.watch("test");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      try {

        System.out.println("Watch put testCrash9 value --> ");
        redisCommands.multi();
        redisCommands.set("test", "testCrash9");

        System.out.println("Exec Result 1"+  redisCommands.exec());
      } catch (Throwable e) {
        System.out.println("Watch 1 throws error----> " + e.getMessage());
      }
      return "putDataWait";
    };
  }

  private Callable<String> putData(RedisClusterCommands redisCommands) {
    return () -> {
      redisCommands.watch("test");
      try {
        System.out.println("Watch put testCrash8 value ---> ");
        redisCommands.multi();
        redisCommands.set("test", "testCrash8");
        System.out.println("Exec Result 2 "+  redisCommands.exec());

      } catch (Throwable e) {
        System.out.println("Watch 2 throws error----> " + e.getMessage());
      }
      return "putData";
    };
  }

}
