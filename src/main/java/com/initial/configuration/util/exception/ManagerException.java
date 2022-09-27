package com.initial.configuration.util.exception;

import com.initial.configuration.util.enums.ErrorCodeEnum;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManagerException {

  private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  
  public static HelloWordException createException(ErrorCodeEnum errorCode, Throwable ex) {
    return new HelloWordException(errorCode.getHttpStatus(),errorCode.name(), ex, errorCode);
  }
  
}
