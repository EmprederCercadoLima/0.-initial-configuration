package com.initial.configuration.proxy.intf;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface IntegrationSwaggerProxyInterface {

  @GET("/integration-swagger/v2/hello-word")
  Call<String> getHelloWord(
      @HeaderMap Map<String, String> headers
  );

}
