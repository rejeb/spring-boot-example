package com.posc.controller;

import com.posc.repository.model.DailyAggregateData;
import com.posc.repository.redis.DailyAggregateDataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buckets")
public class DailyAggregateDataController {
  private final DailyAggregateDataRepository dataRepository;

  public DailyAggregateDataController(DailyAggregateDataRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  @PostMapping()
  public ResponseEntity<DailyAggregateData> postDailyAggregateData(
    @RequestBody
      DailyAggregateData dailyAggregateData) {

    DailyAggregateData saved= dataRepository.save(dailyAggregateData);
    return ResponseEntity.ok(saved);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DailyAggregateData> getDailyAggregateData(
    @PathVariable("id")
      String id) {

    DailyAggregateData saved= dataRepository.findOne(id);
    return ResponseEntity.ok(saved);
  }
}
