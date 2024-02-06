package com.tpi.cathay.surfly.audiovideo.service;

import java.util.Date;

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
public class ImgFileNameUtilTest {
  private static final Logger log = LoggerFactory.getLogger(ImgFileNameUtilTest.class);

  @Test
  public void test0() {
    String date0 = "2025/02/07 11:22:33";
    log.info("date0 {}", date0);
    try {
      Date date = ImgFileNameUtil.sdf.parse(date0);

      String filename = "/record/data/screen/20240205/fekMSYjk2vhThOwKkXs6evkq/fekMSYjk2vhThOwKkXs6evkq_"
          + date.getTime() + ".JPG";
      log.info("filename {}", filename);
      String date1 = ImgFileNameUtil.getFormattedTimeFromImgFile(filename);
      log.info("date0 {} date1 {}", date0, date1);
      Assert.assertEquals(date0, date1);
    } catch (Exception e) {
      Assert.assertTrue(false);
    }
  }

  @Test
  public void test1() {
    String date0 = "2025/02/06 22:24:45";
    log.info("date0 {}", date0);
    try {
      Date date = ImgFileNameUtil.sdf.parse(date0);

      String filename = "/record/data/screen/20240205/fekMSYjk2vhThOwKkXs6evkq/fekMSYjk2vhThOwKkXs6evkq_"
          + date.getTime() + ".JPG";
      log.info("filename {}", filename);
      String date1 = ImgFileNameUtil.getFormattedTimeFromImgFile(filename);
      log.info("date0 {} date1 {}", date0, date1);
      Assert.assertEquals(date0, date1);
    } catch (Exception e) {
      Assert.assertTrue(false);
    }
  }
}
