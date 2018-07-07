package com.posc;

import com.posc.service.PingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public PingService pingService(
    @Value("${posc.ping.url}")
      String pingUrl, RestTemplate restTemplate) {
    return new PingService(restTemplate,pingUrl);
  }
}
