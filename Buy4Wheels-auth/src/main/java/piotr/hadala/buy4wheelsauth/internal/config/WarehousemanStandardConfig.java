package piotr.hadala.buy4wheelsauth.internal.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import piotr.hadala.buy4wheelslib.config.OriginFilter;

@Configuration
public class WarehousemanStandardConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean originFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new OriginFilter());
        frb.setEnabled(true);
        return frb;
    }
}
