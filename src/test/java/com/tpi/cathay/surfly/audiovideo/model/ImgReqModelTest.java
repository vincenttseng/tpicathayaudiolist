package com.tpi.cathay.surfly.audiovideo.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ImgReqModelTest.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("test")
public class ImgReqModelTest {
  private static final Logger log = LoggerFactory.getLogger(ImgReqModelTest.class);

  @Test
  public void test0() {
    log.info("test init");
    Assert.assertTrue(true);
  }
}
