package com.posc.controller;

import com.posc.service.PingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final PingService pingService;

  public TestController(PingService pingService) {
    this.pingService = pingService;
  }

  @GetMapping("/ping")
  public ResponseEntity<String> ping(){
    return ResponseEntity.ok(pingService.ping());
  }
}
