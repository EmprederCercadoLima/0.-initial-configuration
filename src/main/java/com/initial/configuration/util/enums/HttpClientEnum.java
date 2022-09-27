package com.initial.configuration.util.enums;

import lombok.AllArgsConstructor;

import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HttpClientEnum {
  BASE_URL_INTEGRATION_SWAGGER("base_url_integration_swagger"),
  BASE_URL_INTEGRATION_RETROFIT("base_url_integration_retrofit"),
  TIMEOUT_CONNECT("timeout_connect"),
  TIMEOUT_READ("timeout_read"),
  TIMEOUT_WRITE("timeout_write");
  
  private String name;
}
