package piotr.hadala.buy4wheelscar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Buy4WheelsCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(Buy4WheelsCarApplication.class, args);
    }

}
