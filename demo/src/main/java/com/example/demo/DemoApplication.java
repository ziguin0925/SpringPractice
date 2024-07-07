package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		//시작 클래스
		SpringApplication.run(DemoApplication.class, args);

	}

}

