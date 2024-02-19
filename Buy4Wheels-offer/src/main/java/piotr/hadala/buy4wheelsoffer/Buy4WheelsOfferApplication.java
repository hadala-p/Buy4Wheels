package piotr.hadala.buy4wheelsoffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Buy4WheelsOfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(Buy4WheelsOfferApplication.class, args);
	}

}
