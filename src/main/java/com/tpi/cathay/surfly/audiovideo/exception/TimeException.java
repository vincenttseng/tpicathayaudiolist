package com.tpi.cathay.surfly.audiovideo.exception;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class TimeException extends RuntimeException {
  private final String input;

  public TimeException(String input) {
    this.input = input;
  }
}
