package com.posc.controller;

import com.posc.repository.redis.DailyAggregateDataRepository;
import com.posc.repository.model.DailyAggregateData;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buckets")
public class DailyAggregateDataController {
  private final DailyAggregateDataRepository dataRepository;

  public DailyAggregateDataController(DailyAggregateDataRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  @PostMapping()
  @Transactional
  public ResponseEntity<DailyAggregateData> postDailyAggregateData(
    @RequestBody
      DailyAggregateData dailyAggregateData) {
    DailyAggregateData saved= dataRepository.findOne(dailyAggregateData.getId());

     saved= dataRepository.save(dailyAggregateData);
    return ResponseEntity.ok(saved);
  }

  @PostMapping("/wait")
  @Transactional
  public ResponseEntity<DailyAggregateData> postDailyAggregateDataWait(
    @RequestBody
      DailyAggregateData dailyAggregateData) throws InterruptedException {
    DailyAggregateData saved= dataRepository.findOne(dailyAggregateData.getId());
    Thread.sleep(10000);
     saved= dataRepository.save(dailyAggregateData);
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
