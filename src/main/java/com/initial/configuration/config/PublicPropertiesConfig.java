package com.initial.configuration.config;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="application.integration-swagger-v1")
@Getter
@Setter
public class PublicPropertiesConfig {
  
  private Map<String, String> headers;

  private Map<String, String> httpClient;
  
  
  
}
