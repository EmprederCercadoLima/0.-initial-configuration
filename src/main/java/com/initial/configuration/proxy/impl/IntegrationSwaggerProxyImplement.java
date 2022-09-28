package com.initial.configuration.proxy.impl;

import com.initial.configuration.config.PublicPropertiesConfig;
import com.initial.configuration.proxy.intf.IntegrationSwaggerProxyInterface;
import com.initial.configuration.util.ProxyApiResponseUtil;

import com.google.gson.Gson;

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
  
  public ProxyApiResponseUtil getHelloWord(Map<String, String> headers) throws IOException {
    headers.putAll(this.publicPropertiesConfig.getHeaders());
    Call<ProxyApiResponseUtil> retrofitCall = integrationSwaggerProxyInterface.getHelloWord(headers);
    Response<ProxyApiResponseUtil> response = retrofitCall.execute();
    if (response != null && !response.isSuccessful() && response.errorBody() != null) {
      Gson gson = new Gson();
      ProxyApiResponseUtil responseError = gson.fromJson(response.errorBody().charStream(), ProxyApiResponseUtil.class);
      return responseError;
    }
    ProxyApiResponseUtil responseSuccess =  response.body();
    return responseSuccess;
  }
  
}
