package com.posc.controller;



import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.posc.Application;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("it")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                classes = Application.class)
public class TestControllerIT {
  @ClassRule
  public static WireMockClassRule wiremock = new WireMockClassRule(
    WireMockSpring.options().fileSource(new ClasspathFileSource("stubs")).port(9999));

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void testPing() {
    String pong = testRestTemplate.getForObject("/ping", String.class);

    assertEquals("Hello World", pong);
  }

}