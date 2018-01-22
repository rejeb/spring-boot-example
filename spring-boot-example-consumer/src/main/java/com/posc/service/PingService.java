package com.posc.service;

import org.springframework.web.client.RestTemplate;

public class PingService {
  private final RestTemplate restTemplate;

  private final String pingUrl;

  public PingService(RestTemplate restTemplate, String pingUrl) {
    this.restTemplate = restTemplate;
    this.pingUrl = pingUrl;
  }

  public String ping(){
    return restTemplate.getForObject(pingUrl,String.class);
  }
}
