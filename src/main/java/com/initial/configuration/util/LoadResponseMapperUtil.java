package com.initial.configuration.util;

import java.util.List;
import java.util.Map;

public class LoadResponseMapperUtil {

  public static <T> LoadResponseBodyUtil<ListResponseBodyUtil<T>> execute (
      ProxyApiResponseUtil proxyApiResponseUtil) {
    
    List<Map<String, String>> metadata = proxyApiResponseUtil.getMetadata();
    Map<String, List<Map<String, String>>> response = proxyApiResponseUtil.getResponse();
    
    LoadResponseBodyUtil<ListResponseBodyUtil<T>> loadResponseBodyUtil = new LoadResponseBodyUtil<ListResponseBodyUtil<T>>();
        
    List<T> list = (List<T>)response.get("body");

    String statusText = metadata.get(0).get("statusText");
    String statusCode = metadata.get(0).get("statusCode");
    String statusMessage = metadata.get(0).get("statusMessage");
    String componentOrigin = metadata.get(0).get("componentOrigin");

    loadResponseBodyUtil.setMetada(statusCode, statusText, statusMessage, componentOrigin);
    loadResponseBodyUtil.getResponse().setBody(list);
    
    return loadResponseBodyUtil;
  }
  
}
