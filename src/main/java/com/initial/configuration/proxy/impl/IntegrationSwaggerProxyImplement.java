package com.initial.configuration.proxy.impl;

import com.initial.configuration.config.PublicPropertiesConfig;
import com.initial.configuration.controller.response.HelloWordResponse;
import com.initial.configuration.proxy.intf.IntegrationSwaggerProxyInterface;

import java.io.IOException;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

@Service
@Slf4j
public class IntegrationSwaggerProxyImplement {
  
  @Autowired
  private IntegrationSwaggerProxyInterface integrationSwaggerProxyInterface;

  @Autowired
  private PublicPropertiesConfig publicPropertiesConfig;
  
  public HelloWordResponse getHelloWord(Map<String, String> headers) throws IOException {
    headers.putAll(this.publicPropertiesConfig.getHeaders());
    Call<HelloWordResponse> retrofitCall = integrationSwaggerProxyInterface.getHelloWord(headers);
    Response<HelloWordResponse> response = retrofitCall.execute();
    if (response != null && !response.isSuccessful() && response.errorBody() != null) {
      log.error("error:getHelloWord:integrationSwaggerProxyInterface:response.errorBody{}", response.errorBody());
    }
    log.info(":getHelloWord:integrationSwaggerProxyInterface:response{}", response.body().getMetadata().get(0).get("statusText"));
    return response.body();
  }
  
}
