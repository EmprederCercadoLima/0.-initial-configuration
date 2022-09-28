package com.initial.configuration.business.intf;

import com.initial.configuration.controller.response.HelloWordResponse;

import java.io.IOException;

import java.util.Map;

public interface InitialConfigurationBusinessInterface {
  public HelloWordResponse getHelloWordCustomized(String firstName, Map<String, String> headers) throws IOException;
}
