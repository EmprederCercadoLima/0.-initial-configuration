package com.initial.configuration.util;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertiesHeaderUtil {
  
  private Map<String, String> headers;

  private Map<String, String> httpClient;
}
