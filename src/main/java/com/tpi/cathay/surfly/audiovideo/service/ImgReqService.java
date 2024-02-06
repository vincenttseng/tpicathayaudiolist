package com.tpi.cathay.surfly.audiovideo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.tpi.cathay.surfly.audiovideo.exception.InputParamException;
import com.tpi.cathay.surfly.audiovideo.model.ImgReqModel;
import com.tpi.cathay.surfly.audiovideo.model.ScreenShotVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
@Configuration
@ConfigurationProperties(prefix = "record")
public class ImgReqService {
  private static final Logger log = LoggerFactory.getLogger(ImgReqService.class);

  private String imgRoot;

  private String audioRoot;

  @PostConstruct
  public void init() {
    log.info("imgRoot {}", imgRoot);
    log.info("audioRoot {}", audioRoot);
  }

  public void checkModelParam(ImgReqModel model) {
    checkTimestampFolder(model);
    checkSessionIDFolder(model);
    checkConnIDAndVoicePath(model);
  }

  /**
   * folder existed?
   * 
   * @param model
   * @throws InputParamException
   */
  public void checkTimestampFolder(ImgReqModel model) throws InputParamException {
    String targetImgFolder = imgRoot + model.getTimeStamp();
    File file = new File(targetImgFolder);
    if (!file.exists()) {
      throw new InputParamException(targetImgFolder + " not existed");
    }
  }

  /**
   * folder existed?
   * 
   * @param model
   * @throws InputParamException
   */
  public void checkSessionIDFolder(ImgReqModel model) throws InputParamException {
    String targetImgFolder = imgRoot + model.getTimeStamp() + File.separator + model.getSessionID();

    File file = new File(targetImgFolder);
    if (!file.exists()) {
      throw new InputParamException(targetImgFolder + " not existed");
    }
  }

  /**
   * ConnID VoicePath existed and VoicePath.startsWith(ConnID)
   * 
   * @param model
   * @throws InputParamException
   */
  public void checkConnIDAndVoicePath(ImgReqModel model) throws InputParamException {
    if (StringUtils.isAnyEmpty(model.getConnID(), model.getVoicePath())
        || !model.getVoicePath().startsWith(model.getConnID())) {
      throw new InputParamException("Naming ConnID :" + model.getConnID() + " VoicePath:" + model.getVoicePath());
    }

    if (!model.getVoicePath().toLowerCase().endsWith("wav")) {
      throw new InputParamException("Naming :" + model.getVoicePath() + " not wav");
    }

    String targetAudioFile = audioRoot + model.getVoicePath();
    File file = new File(targetAudioFile);
    if (!file.exists()) {
      throw new InputParamException(targetAudioFile + " not existed");
    }
  }
  
  public List<ScreenShotVO> getScreenShotVOList(ImgReqModel model) {
    List<ScreenShotVO> list = new ArrayList<ScreenShotVO>();

    
    return list;
  }

}
