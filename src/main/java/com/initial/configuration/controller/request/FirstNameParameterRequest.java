package com.initial.configuration.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirstNameParameterRequest {
  
  @Schema(
      name="firstName",
      example="Carlos enrique",
      required=true,
      type="string"
      )
  @NotEmpty
  private String firstName;
  
}
