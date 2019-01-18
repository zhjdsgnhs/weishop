package cn.weishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@MapperScan("cn.weishop.mapper")
@EnableCaching
public class WeishopApplication {	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WeishopApplication.class, args);
	}
}
