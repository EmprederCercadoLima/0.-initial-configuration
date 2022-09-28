package com.initial.configuration.mapper.impl;

import com.initial.configuration.controller.response.FindUserCommerceResponse;
import com.initial.configuration.mapper.intf.ProxyToBusinessMapperInterface;
import com.initial.configuration.util.ListResponseBodyUtil;
import com.initial.configuration.util.LoadResponseBodyUtil;
import com.initial.configuration.util.LoadResponseMapperUtil;
import com.initial.configuration.util.ProxyApiResponseUtil;

import java.util.List;
import java.util.Map;

import javax.annotation.processing.Generated;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
@Slf4j
public class ProxyToBusinessMapperImplement implements ProxyToBusinessMapperInterface {

  @Override
  public <FindUserCommerceResponse> LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceResponse>> proxyApiResponseUtilToLoadFindUserCommerceResponse(
      ProxyApiResponseUtil proxyApiResponseUtil) {
    
    if(proxyApiResponseUtil == null) {
      return null;
    }
    
    LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceResponse>> loadResponseBodyUtil = LoadResponseMapperUtil.execute(proxyApiResponseUtil);
    return loadResponseBodyUtil;
  }

  @Override
  public <FindUserCommerceBusinessResponse> LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceBusinessResponse>> proxyApiResponseUtilToLoadFindUserCommerceBusinessResponse(
      ProxyApiResponseUtil proxyApiResponseUtil) {

    if(proxyApiResponseUtil == null) {
      return null;
    }
    
    LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceBusinessResponse>> loadResponseBodyUtil =  LoadResponseMapperUtil.execute(proxyApiResponseUtil);
   
    return loadResponseBodyUtil;
  }
  
}
