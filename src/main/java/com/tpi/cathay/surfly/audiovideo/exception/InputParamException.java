package com.tpi.cathay.surfly.audiovideo.exception;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class InputParamException extends RuntimeException {
  private final String input;

  public InputParamException(String input) {
    super(input);
    this.input = input;
  }
}
