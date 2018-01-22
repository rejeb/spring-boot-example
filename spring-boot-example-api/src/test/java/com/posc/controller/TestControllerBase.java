package com.posc.controller;



import com.posc.service.PingService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerBase {


  @Autowired
  private TestController testController;

  @MockBean
  private PingService pingService;

  @Before
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(testController);

    Mockito.when(pingService.ping())
           .thenReturn("Hello pong.");

  }

}
