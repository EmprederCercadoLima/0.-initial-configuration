package com.initial.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.com.niubiz.web.runner.StarterWebApplication;

@SpringBootApplication
public class Application extends StarterWebApplication  {

	public static void main(String[] args) {
	  new SpringApplication(Application.class).run(args);
	}

}
