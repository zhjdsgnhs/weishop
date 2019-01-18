package cn.weishop;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@SpringBootApplication
@MapperScan("cn.weishop.mapper")
public class WeishopApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WeishopApplication.class, args); 
	}
	
	
	@Bean
	public PaginationInterceptor pageinationInterceptor(){
		return new PaginationInterceptor(); 
	}
	
	 
	 
}
