package org.iwp.iWare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
		{"org.iwp.iWare", "org.iwp.user","org.iwp.common","org.iwp.device","org.iwp.maintaince"})
@MapperScan(basePackages =
		{"org.iwp.user.dao", "org.iwp.device.dao","org.iwp.maintaince.dao"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
