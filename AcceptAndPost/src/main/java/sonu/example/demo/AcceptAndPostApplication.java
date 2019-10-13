package sonu.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AcceptAndPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcceptAndPostApplication.class, args);
	}


}
@Configuration
class BeanCreater
{
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}