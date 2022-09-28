package com.initial.configuration.business.intf;

import com.initial.configuration.util.LoadResponseBodyUtil;

import java.io.IOException;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface InitialConfigurationBusinessInterface {
  public ResponseEntity<LoadResponseBodyUtil> getHelloWordCustomized(String firstName, Map<String, String> headers) throws IOException;
}
