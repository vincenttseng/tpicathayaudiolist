package com.tpi.cathay.surfly.audiovideo.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
          + date.getTime() + ".jpg";
      log.info("filename {}", filename);
      String date1 = ImgFileNameUtil.getFormattedTimeFromImgFile(filename);
      log.info("date0 {} date1 {}", date0, date1);
      Assert.assertEquals(date0, date1);
    } catch (Exception e) {
      Assert.assertTrue(false);
    }
  }

  @Autowired
  ImgReqService imgReqService;

  @Ignore
  @Test
  /**
   * create sample test file for parsing
   */
  public void genFileList() {
    String timestamp = "20240205";
    String sessionId = "fekMSYjk2vhThOwKkXs6evkq";
    
    List<String> list = new ArrayList<String>();
    list.add("2024/02/05 22:24:45");
    list.add("2024/02/05 22:24:50");
    list.add("2024/02/05 22:25:01");
    list.add("2024/02/05 22:25:01");
    list.add("2024/02/05 22:25:09");
    list.add("2024/02/05 22:25:15");
    list.add("2024/02/05 22:25:22");
    list.add("2024/02/05 22:25:30");
    
    list.stream().forEach(dateStr ->{
      String filename = imgReqService.getImgRoot() + timestamp + File.separator + sessionId + File.separator + sessionId + "_";
      try {
        Date dateTmp = ImgFileNameUtil.sdf.parse(dateStr);
        filename += dateTmp.getTime() + ".jpg";
        File file = new File(filename);
        file.createNewFile();
        log.info(filename);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }
}
