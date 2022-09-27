package com.initial.configuration.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.initial.configuration.util.enums.ErrorCodeEnum;
import com.initial.configuration.util.exception.ApiErrorException;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "application") 
@Getter
@Setter
public class ExceptionPropertiesConfig {
  private Map<ErrorCodeEnum, ApiErrorException> errors;
}