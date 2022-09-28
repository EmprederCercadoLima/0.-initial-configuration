package com.initial.configuration.business.impl;

import com.initial.configuration.business.intf.InitialConfigurationBusinessInterface;
import com.initial.configuration.controller.response.FindUserCommerceResponse;
import com.initial.configuration.mapper.impl.ProxyToBusinessMapperImplement;
import com.initial.configuration.proxy.impl.IntegrationSwaggerProxyImplement;
import com.initial.configuration.util.LoadResponseBodyUtil;
import com.initial.configuration.util.ProxyApiResponseUtil;
import com.initial.configuration.util.enums.ErrorCodeEnum;
import com.initial.configuration.util.exception.HelloWordException;
import com.initial.configuration.util.ListResponseBodyUtil;

import java.io.IOException;

import java.util.Map;

import javax.security.sasl.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitialConfigurationBusinessImplement implements InitialConfigurationBusinessInterface {

  @Autowired
  private IntegrationSwaggerProxyImplement integrationSwaggerProxyImplement;
  
  @Autowired
  private ProxyToBusinessMapperImplement proxyToBusinessMapperImplement;
  
  @Override
  public ResponseEntity<LoadResponseBodyUtil> getHelloWordCustomized(String firstName,  Map<String, String> headers) throws IOException {
    
    // Colocar Fernando.Zavaleta para lanzar excepcion hello word exception
    log.info("firstName: {}", firstName);
    if(firstName.equals("1Fernando.Zavaleta")) {
      throw new HelloWordException(HttpStatus.BAD_REQUEST, firstName, null, ErrorCodeEnum.BAD_REQUEST_EXCEPTION);
    }
    
    
    ProxyApiResponseUtil proxyApiResponse = integrationSwaggerProxyImplement.getHelloWord(headers);
    
    LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceResponse>> loadResponseBodyUtil = proxyToBusinessMapperImplement.proxyApiResponseUtilToLoadFindUserCommerceResponse(proxyApiResponse);
    
    return new ResponseEntity<LoadResponseBodyUtil>(loadResponseBodyUtil, HttpStatus.OK);
    
  }

}
