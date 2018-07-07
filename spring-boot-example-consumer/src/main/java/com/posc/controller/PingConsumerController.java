package com.posc.controller;

import com.posc.service.PingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingConsumerController {

  private final PingService pingService;

  public PingConsumerController(PingService pingService) {
    this.pingService = pingService;
  }

  @GetMapping("/ping")
  public ResponseEntity<String> ping(){
    return ResponseEntity.ok(pingService.ping());
  }
}
