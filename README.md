# 0.-initial-configuration

aplication.yml

server:
  port: 8091
spring:
  cloud:
   config:
     enabled: false
  application:
    name: initial-configuration
application:
  integration-swagger-v1:
    httpclient:
      base-url: http://localhost:8080
      timeout-connect: 60
      timeout-read: 60
      timeout-write: 60
    headers:
      app-code: INTEGRATION-SWAGGER
      org-code: 1
  integration-retrofit-v1:
    httpclient:
      base-url: http://localhost:8090
      timeout-connect: 60
      timeout-read: 60
      timeout-write: 60
    headers:
      app-code: INTEGRATION-RETROFIT
      org-code: 2
