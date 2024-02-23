package piotr.hadala.buy4wheelsauth.internal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import piotr.hadala.buy4wheelsauth.application.controllers.TokenController;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenResponseDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyRequestDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyResponseDTO;
import piotr.hadala.buy4wheelsauth.internal.services.TokenService;

@RequiredArgsConstructor
@RestController
public class TokenControllerImpl implements TokenController {
    private final TokenService service;
    @Override
    public ResponseEntity<TokenResponseDTO> getToken() {
        return ResponseEntity.ok(service.getToken());
    }

    @Override
    public ResponseEntity<TokenVerifyResponseDTO> verifyToken(TokenVerifyRequestDTO requestDTO) {
        return ResponseEntity.ok(service.verifyToken(requestDTO));
    }
}
