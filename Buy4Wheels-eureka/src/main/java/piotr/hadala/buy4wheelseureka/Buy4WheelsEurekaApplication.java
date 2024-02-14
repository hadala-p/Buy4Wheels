package piotr.hadala.buy4wheelseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaServer
public class Buy4WheelsEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Buy4WheelsEurekaApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){ return new RestTemplate();}

}
