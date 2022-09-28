package com.initial.configuration.proxy.intf;

import com.initial.configuration.util.ProxyApiResponseUtil;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface IntegrationSwaggerProxyInterface {

  @GET("/integration-swagger/v1/find-user-commerce")
  Call<ProxyApiResponseUtil> getHelloWord(
      @HeaderMap Map<String, String> headers
  );

}
