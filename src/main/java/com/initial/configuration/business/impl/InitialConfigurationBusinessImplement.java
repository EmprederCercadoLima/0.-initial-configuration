package com.initial.configuration.business.impl;

import com.initial.configuration.business.intf.InitialConfigurationBusinessInterface;
import com.initial.configuration.controller.InitialConfigurationController;
import com.initial.configuration.controller.response.HelloWordResponse;
import com.initial.configuration.proxy.impl.IntegrationSwaggerProxyImplement;
import com.initial.configuration.proxy.intf.IntegrationSwaggerProxyInterface;

import java.io.IOException;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitialConfigurationBusinessImplement implements InitialConfigurationBusinessInterface {

  @Autowired
  private IntegrationSwaggerProxyImplement integrationSwaggerProxyImplement;
  
  @Override
  public HelloWordResponse getHelloWordCustomized(String firstName,  Map<String, String> headers) throws IOException {
    return integrationSwaggerProxyImplement.getHelloWord(headers);
  }

}
