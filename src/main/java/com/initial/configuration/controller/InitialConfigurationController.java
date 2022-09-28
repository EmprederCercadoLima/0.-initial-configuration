package com.initial.configuration.controller;

import com.initial.configuration.business.intf.InitialConfigurationBusinessInterface;
import com.initial.configuration.controller.request.HeadersRequest;
import com.initial.configuration.controller.response.HelloWordResponse;
import com.initial.configuration.util.StringsUtil;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springdoc.api.annotations.ParameterObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.niubiz.core.annotation.HttpHeadersMapping;

@RestController
@Validated
@RequestMapping("/initial-configuration/v1.0/controller-name")
@Slf4j
public class InitialConfigurationController {

  @Autowired
  private InitialConfigurationBusinessInterface initialConfigurationBusinessInterface;
  
  @GetMapping("/hello-word")
  public HelloWordResponse getHelloWord(
    @ParameterObject @HttpHeadersMapping HeadersRequest headerRequest) throws IOException {
    return initialConfigurationBusinessInterface.getHelloWordCustomized("Fernando.Zavaleta",  StringsUtil.headerValidate(headerRequest.getClientCode(), headerRequest.getPublicIp()));
  }
  
}
