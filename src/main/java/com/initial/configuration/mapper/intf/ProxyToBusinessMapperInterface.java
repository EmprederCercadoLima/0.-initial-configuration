package com.initial.configuration.mapper.intf;

import com.initial.configuration.util.ListResponseBodyUtil;
import com.initial.configuration.util.LoadResponseBodyUtil;
import com.initial.configuration.util.ProxyApiResponseUtil;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProxyToBusinessMapperInterface {

  <FindUserCommerceResponse> LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceResponse>> proxyApiResponseUtilToLoadFindUserCommerceResponse(ProxyApiResponseUtil proxyApiResponseUtil);
  <FindUserCommerceBusinessResponse> LoadResponseBodyUtil<ListResponseBodyUtil<FindUserCommerceBusinessResponse>> proxyApiResponseUtilToLoadFindUserCommerceBusinessResponse(ProxyApiResponseUtil proxyApiResponseUtil);
}