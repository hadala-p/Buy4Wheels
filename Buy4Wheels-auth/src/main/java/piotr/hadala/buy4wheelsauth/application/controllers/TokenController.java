package piotr.hadala.buy4wheelsauth.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenResponseDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyRequestDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyResponseDTO;

public interface TokenController {
    @GetMapping("/token")
    ResponseEntity<TokenResponseDTO> getToken();

    @PostMapping("/token/verify")
    ResponseEntity<TokenVerifyResponseDTO> verifyToken(@RequestBody TokenVerifyRequestDTO requestDTO);
}
