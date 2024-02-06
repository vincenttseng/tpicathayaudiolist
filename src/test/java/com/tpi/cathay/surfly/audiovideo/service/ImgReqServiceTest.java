package com.tpi.cathay.surfly.audiovideo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.tpi.cathay.surfly.audiovideo.SpringBootJspApplication;
import com.tpi.cathay.surfly.audiovideo.exception.InputParamException;
import com.tpi.cathay.surfly.audiovideo.model.ImgReqModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJspApplication.class)
@ActiveProfiles("dev")
public class ImgReqServiceTest {
  private static final Logger log = LoggerFactory.getLogger(ImgReqServiceTest.class);

  @Autowired
  ImgReqService imgReqService;

  @Test
  public void checkAuto() {
    log.info("{}", imgReqService);
    Assert.assertNotNull(imgReqService);
  }

  @Test
  public void testValue() {
    log.info("{}", imgReqService.getAudioRoot());
    log.info("{}", imgReqService.getImgRoot());
  }

  @Test
  public void testCheckModelTimestamp0() {
    ImgReqModel model = ImgReqModel.builder().timeStamp("abcdef").build();
    try {
      imgReqService.checkTimestampFolder(model);
      Assert.assertTrue(false);
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testCheckModelTimestamp1() {
    ImgReqModel model = ImgReqModel.builder().timeStamp("20240205").build();
    try {
      imgReqService.checkTimestampFolder(model);
      Assert.assertTrue(true);
      log.info("seccessfully with file path for {}", model.getTimeStamp());
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(false);
    }
  }

  @Test
  public void testCheckModelSessionId0() {
    ImgReqModel model = ImgReqModel.builder().timeStamp("20240205").sessionID("dfasdfasdf").build();
    try {
      imgReqService.checkSessionIDFolder(model);
      Assert.assertTrue(false);
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testCheckModelSessionId1() {
    ImgReqModel model = ImgReqModel.builder().timeStamp("20240205").sessionID("fekMSYjk2vhThOwKkXs6evkq").build();
    try {
      imgReqService.checkSessionIDFolder(model);
      Assert.assertTrue(true);

      log.info("seccessfully with file path for {} {}", model.getTimeStamp(), model.getSessionID());
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(false);
    }
  }

  @Test
  public void testConnIdAndVoice0() {
    ImgReqModel model = ImgReqModel.builder().connID("0312312322")
        .voicePath("012503629b639b24_2023-12-28_01-20-27_2009_63299.wav").build();

    try {
      imgReqService.checkConnIDAndVoicePath(model);
      Assert.assertTrue(false);
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testConnIdAndVoice1() {
    ImgReqModel model = ImgReqModel.builder().connID("012503629b639b24")
        .voicePath("012503629b639b24_2023-12-28_01-20-27_2009_63299.jpg").build();

    try {
      imgReqService.checkConnIDAndVoicePath(model);
      Assert.assertTrue(false);
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testConnIdAndVoice2() {
    ImgReqModel model = ImgReqModel.builder().connID("012503629b639b25")
        .voicePath("012503629b639b25_2023-12-28_01-20-27_2009_63299.wav").build();

    try {
      imgReqService.checkConnIDAndVoicePath(model);
      Assert.assertTrue(false);
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(true);
    }
  }
  
  @Test
  public void testConnIdAndVoice3() {
    ImgReqModel model = ImgReqModel.builder().connID("012503629b639b24")
        .voicePath("012503629b639b24_2023-12-28_01-20-27_2009_63299.wav").build();

    try {
      imgReqService.checkConnIDAndVoicePath(model);
      Assert.assertTrue(true);
      log.info("seccessfully with file path for {} {}", model.getVoicePath());
    } catch (InputParamException e) {
      log.info("error " + e.getMessage());
      Assert.assertTrue(false);
    }
  }
}
