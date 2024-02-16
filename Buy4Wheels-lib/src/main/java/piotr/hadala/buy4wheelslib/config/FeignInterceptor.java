package piotr.hadala.buy4wheelslib.config;

import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements feign.RequestInterceptor {
    @Override
    public void apply(feign.RequestTemplate template) {
        template.header("Authorization", Context.getAuthToken());
    }
}
