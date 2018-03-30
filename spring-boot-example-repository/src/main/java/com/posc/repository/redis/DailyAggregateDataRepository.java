package com.posc.repository.redis;

import com.posc.repository.model.DailyAggregateData;
import org.springframework.data.repository.CrudRepository;

public interface DailyAggregateDataRepository extends CrudRepository<DailyAggregateData, String> {
}
