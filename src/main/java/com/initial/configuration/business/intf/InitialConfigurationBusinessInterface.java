package com.initial.configuration.business.intf;

import java.io.IOException;

import java.util.Map;

public interface InitialConfigurationBusinessInterface {
  public String getHelloWordCustomized(String firstName, Map<String, String> headers) throws IOException;
}
