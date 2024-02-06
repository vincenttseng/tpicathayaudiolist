package com.tpi.cathay.surfly.audiovideo.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.tpi.cathay.surfly.audiovideo.SpringBootJspApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJspApplication.class)
@ActiveProfiles("dev")
public class ImgReqModelTest {
  private static final Logger log = LoggerFactory.getLogger(ImgReqModelTest.class);

  @Test
  public void test0() {
    log.info("test init");
    Assert.assertTrue(true);
  }
}
