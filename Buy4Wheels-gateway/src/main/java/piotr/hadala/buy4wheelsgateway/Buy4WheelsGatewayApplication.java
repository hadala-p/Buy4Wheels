package piotr.hadala.buy4wheelsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Buy4WheelsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Buy4WheelsGatewayApplication.class, args);
    }

}
