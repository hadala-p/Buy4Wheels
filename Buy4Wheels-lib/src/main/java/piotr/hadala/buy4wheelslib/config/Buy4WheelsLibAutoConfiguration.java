package piotr.hadala.buy4wheelslib.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan
public class Buy4WheelsLibAutoConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContextInterceptor());
    }
}
