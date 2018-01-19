package com.posc.controller;



import com.posc.service.PingService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

  @Autowired
  private MockMvc mvc;
  @MockBean
  private PingService pingService;

  @Test
  public void ping() throws Exception {
    String expected = "pong test.";
    given(pingService.ping()).willReturn(expected);

    this.mvc.perform(get("/ping").accept(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk())
            .andExpect(content().string("pong test."));
  }
}
