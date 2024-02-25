package piotr.hadala.buy4wheelsoffer.internal.client;

import org.springframework.cloud.openfeign.FeignClient;
import piotr.hadala.buy4wheelsauth.application.controllers.TokenController;

@FeignClient(url = "${apis.buy4wheels-auth.url}", name = "buy4wheels-auth")
public interface TokenClient extends TokenController {
}