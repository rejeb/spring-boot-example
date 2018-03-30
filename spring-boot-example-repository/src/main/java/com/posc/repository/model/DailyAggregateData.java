package com.posc.repository.model;

import com.google.common.collect.ImmutableMap;
import org.springframework.data.redis.core.RedisHash;

import java.util.HashMap;
import java.util.Map;

@RedisHash("DailyAggregateData")
public class DailyAggregateData {

  private final String id;

  private final Map<String, String> bucketValues;

  private DailyAggregateData() {
    this.id = null;
    this.bucketValues = null;
  }

  public DailyAggregateData(String id, Map<String, String> bucketValues) {
    this.id = id;
    this.bucketValues = ImmutableMap.copyOf(bucketValues);
  }

  public Map<String, String> getBucketValues() {
    return bucketValues;
  }

  public String getBucketValuesByKey(final String key) {
    return this.getBucketValues().get(key);
  }

  public String getId() {
    return id;
  }

}
