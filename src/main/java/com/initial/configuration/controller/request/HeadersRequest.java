package com.initial.configuration.controller.request;

import com.initial.configuration.util.ConstantsUtil;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

import pe.com.niubiz.core.model.base.AuditHttpHeadersRequest;

@Data
public class HeadersRequest extends AuditHttpHeadersRequest {
  
  @JsonProperty("client-code")
  @NotEmpty(message = "client-code no puede ser vacío")
  @Pattern(regexp = ConstantsUtil.REGEX_ONLY_ALFA, 
      message = "client-code debe ser alfanumerico")
  @Parameter(in = ParameterIn.HEADER, 
      description  = "Código del cliente.", 
      name = "client-code", 
      required = true, example = "ABCD")
  private String clientCode;
  
  @JsonProperty("public-ip")
  @Pattern(regexp = ConstantsUtil.REGEX_IP_ADD, 
      message = "public-ip debe ser una IP válida")
  @NotEmpty(message = "public-ip no puede ser vacío")
  @Parameter(in = ParameterIn.HEADER, 
      description  = "IP Publica.", 
      name = "public-ip", 
      required = true, example = "192.168.1.1")
  private String publicIp;
  
}
