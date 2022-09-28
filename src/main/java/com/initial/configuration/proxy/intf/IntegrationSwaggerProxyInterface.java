package com.initial.configuration.proxy.intf;

import com.initial.configuration.controller.response.HelloWordResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface IntegrationSwaggerProxyInterface {

  @GET("/integration-swagger/v1/hello-word")
  Call<HelloWordResponse> getHelloWord(
      @HeaderMap Map<String, String> headers
  );

}
