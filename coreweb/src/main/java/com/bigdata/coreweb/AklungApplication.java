package com.bigdata.coreweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bigdata.coreweb.mapper")
@SpringBootApplication
public class AklungApplication {

	public static void main(String[] args) {
		SpringApplication.run(AklungApplication.class, args);
	}

}
