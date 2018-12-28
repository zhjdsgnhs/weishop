package cn.weishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.weishop.mapper")
public class WeishopApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WeishopApplication.class, args);
	}
	
}
