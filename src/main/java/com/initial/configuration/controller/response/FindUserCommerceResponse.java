package com.initial.configuration.controller.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FindUserCommerceResponse {
  private String idUser;
  private String email;
  private String password;

}
