package com.initial.configuration.util;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProxyApiResponseUtil {

  private List<Map<String, String>> metadata;

  private Map<String, List<Map<String, String>>> response;
  
}
