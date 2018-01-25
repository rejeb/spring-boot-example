package com.posc.service;

import org.springframework.web.client.RestTemplate;

public class PingService {
  private final String pingUrl;
  private final RestTemplate restTemplate;

  public PingService(String pingUrl, RestTemplate restTemplate) {
    this.pingUrl = pingUrl;
    this.restTemplate = restTemplate;
  }

  public String ping() {
    return "Hello pong.";
  }
}
