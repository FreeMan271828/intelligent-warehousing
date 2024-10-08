package org.iwp.iWare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.iwp.iWare", "org.iwp.user","org.iwp.common"})
@MapperScan(basePackages = "org.iwp.user.dao")
public class IntelligentWarehousingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntelligentWarehousingApplication.class, args);
	}

}
