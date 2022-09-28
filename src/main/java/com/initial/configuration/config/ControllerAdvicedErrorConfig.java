package com.initial.configuration.config;

import com.initial.configuration.util.StringsUtil;
import com.initial.configuration.util.enums.ErrorCodeEnum;
import com.initial.configuration.util.exception.HelloWordException;

import java.nio.file.AccessDeniedException;

import java.util.Objects;

import javax.security.sasl.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pe.com.niubiz.core.constants.ErrorCategory;
import pe.com.niubiz.core.exception.BespinException;

@RestControllerAdvice
@Slf4j
public class ControllerAdvicedErrorConfig {

  @Autowired
  private ExceptionPropertiesConfig exceptionPropertiesConfig;

  @ResponseBody
  @ExceptionHandler(value = HelloWordException.class)
  public ResponseEntity<Object> handleException(HelloWordException ex) {
    log.error(" 1 CUSTOM EXCEPTION => ", ex);
    String code = ex.isExternalErrorCode()
        ? ex.getReason()
        : exceptionPropertiesConfig.getErrors().get(ex.getErrorCode()).getCode();
    this.logCustomError(" 1 CUSTOM EXCEPTION", code);
    return ResponseEntity
        .status(ex.getStatus())
        .body(BespinException.builder().systemCode(code).build());
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(AuthenticationException.class)
  public BespinException exception(AuthenticationException ex) {
    log.error(" 2 EXCEPTION - UNAUTHORIZED: ", ex);
    String code = exceptionPropertiesConfig.getErrors().get(ErrorCodeEnum.UNAUTHORIZED_EXCEPTION).getCode();
    this.logCustomError(" 2 EXCEPTION - UNAUTHORIZED", code);
    return BespinException.builder().systemCode(code).build();
  }

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler(AccessDeniedException.class)
  public BespinException exception(AccessDeniedException ex) {
    log.error(" 3 EXCEPTION - FORBIDDEN: ", ex);
    String code = exceptionPropertiesConfig.getErrors().get(ErrorCodeEnum.FORBIDDEN_EXCEPTION).getCode();
    this.logCustomError(" 3 EXCEPTION - FORBIDDEN", code);
    return BespinException.builder().systemCode(code).build();
  }
  

  @ExceptionHandler(BespinException.class)
  public ResponseEntity<BespinException> exception(BespinException ex) {
    log.error(" 4 EXCEPTION - UNAUTHORIZED: ", ex);
    String code = Objects.isNull(ex.getCode())
        ? exceptionPropertiesConfig.getErrors().get(ErrorCodeEnum.SERVER_ERROR_EXCEPTION).getCode()
        : ex.getCode();
    
    this.logCustomError(" 4 EXCEPTION - UNAUTHORIZED", code);
    return ResponseEntity.status(this.fromCategoryToHttpStatus(ex.getCategory())).body(
        BespinException.builder().category(ex.getCategory()).systemCode(code).build());
  }

  private void logCustomError(String msg, String code) {
    log.error(
        StringsUtil.replaceSpaces(msg.concat(" CODE => {}")),
        StringsUtil.replaceSpaces("ERROR-".concat(code)));
  }
  
  private HttpStatus fromCategoryToHttpStatus(ErrorCategory errorCategory) {
    if (errorCategory == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    } else {
      return HttpStatus.valueOf(errorCategory.getHttpStatus());
    }
  }
  
}
