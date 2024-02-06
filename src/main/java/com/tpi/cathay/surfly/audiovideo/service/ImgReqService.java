package com.tpi.cathay.surfly.audiovideo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ImgReqService {
  private static final Logger log = LoggerFactory.getLogger(ImgReqService.class);

  public void check() {
    log.info("check");
  }
}
