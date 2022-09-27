package com.initial.configuration.util;

import com.initial.configuration.util.enums.ExternalApiEnum;

import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringsUtil {
  
  public static String replaceSpaces(String msg) {
    String resultado = "";
    if (msg != null) {
      resultado = msg.replaceAll("[\r\n]","");
    }
    return resultado;
  }

  public static String customExternalCode(ExternalApiEnum externalApi, String externalCode) {
    return externalApi.getSuffixCode().concat(
        String.valueOf(Integer.parseInt(externalCode.replaceAll("\\D+",""))));
  }

  public static Map<String, String> headerValidate(String clientCode, String publicIp) {
    log.info("HttpHeaders: [[public-ip]:{};[client-code]:{}]", replaceSpaces(clientCode),
        replaceSpaces(publicIp));
    Map<String, String> headers = new HashMap<>();
    if (publicIp != null) {
      headers.put("public-ip", publicIp);
    }
    return headers;
  }
  
  public static String dateTransform(ChronoLocalDate value) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    return value.format(formatter);
  } 
}
