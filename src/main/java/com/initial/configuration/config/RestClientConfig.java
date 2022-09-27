package com.initial.configuration.config;

import com.initial.configuration.proxy.intf.IntegrationRetrofitProxyInterface;
import com.initial.configuration.proxy.intf.IntegrationSwaggerProxyInterface;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.niubiz.core.httpclient.utils.ApiOkHttpClient;

@Configuration
@Slf4j
public class RestClientConfig {
  
  @Bean
  IntegrationSwaggerProxyInterface integrationSwaggerProxyApi(
      @Value("${application.integration-swagger-v1.httpclient.base-url}") String url,
      @Value("${application.integration-swagger-v1.httpclient.timeout-connect}") Integer timeoutConnect,
      @Value("${application.integration-swagger-v1.httpclient.timeout-read}") Integer timeoutRead,
      @Value("${application.integration-swagger-v1.httpclient.timeout-write}") Integer timeoutWrite,
      @Qualifier("bespin.default") CircuitBreaker circuitBreaker
      ) {
    log.info("integrationSwaggerProxyApi url:{}, timeout-connect:{}, timeout-read:{}, timeout-write:{}", url, timeoutConnect, timeoutRead, timeoutWrite);
    IntegrationSwaggerProxyInterface integrationSwaggerProxyInterface = ApiOkHttpClient.builder()
        .connectTimeout(timeoutConnect)
        .readTimeOut(timeoutRead)
        .writeTimeOut(timeoutWrite)
        .circuitBreaker(circuitBreaker).url(url).build().buildProxy(IntegrationSwaggerProxyInterface.class);
    log.info("IntegrationSwaggerProxyInterface:{}", integrationSwaggerProxyInterface);
    return integrationSwaggerProxyInterface;
  }
  
  @Bean
  IntegrationRetrofitProxyInterface integrationRetrofitProxyApi(
      @Value("${application.integration-retrofit-v1.httpclient.base-url}") String url,
      @Value("${application.integration-retrofit-v1.httpclient.timeout-connect}") Integer timeoutConnect,
      @Value("${application.integration-retrofit-v1.httpclient.timeout-read}") Integer timeoutRead,
      @Value("${application.integration-retrofit-v1.httpclient.timeout-write}") Integer timeoutWrite,
      @Qualifier("bespin.default") CircuitBreaker circuitBreaker
      ) {
     log.info("integrationRetrofitProxyApi url:{}, timeout-connect:{}, timeout-read:{}, timeout-write:{}", url, timeoutConnect, timeoutRead, timeoutWrite);
     IntegrationRetrofitProxyInterface  integrationRetrofitProxyInterface = ApiOkHttpClient.builder()
        .connectTimeout(timeoutConnect)
        .readTimeOut(timeoutRead)
        .writeTimeOut(timeoutWrite)
        .circuitBreaker(circuitBreaker).url(url).build().buildProxy(IntegrationRetrofitProxyInterface.class);
     log.info("integrationRetrofitProxyApi:{}", integrationRetrofitProxyInterface);
     return integrationRetrofitProxyInterface;
  }
  
}
