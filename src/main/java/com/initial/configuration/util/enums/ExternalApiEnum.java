package com.initial.configuration.util.enums;

import lombok.AllArgsConstructor;

import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExternalApiEnum {
  
  ERROR_INTEGRATION_SWAGGER("ERROR_INTEGRATION_SWAGGER"),
  ERROR_INTEGRATION_RETROFIT("ERROR_INTEGRATION_RETROFIT");
  
  private String suffixCode;
}
