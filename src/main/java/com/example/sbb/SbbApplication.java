package com.example.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SbbApplication.class, args);
	}
	//기본 port는 8080이다.
	//해당 port로 접속이 되지 않을 경우에 application.properties에서
	//port 번호를 변경할 것
	//"localhost:8080/"
}
