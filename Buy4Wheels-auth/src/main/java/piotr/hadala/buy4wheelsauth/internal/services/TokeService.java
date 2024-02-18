package piotr.hadala.buy4wheelsauth.internal.services;


import piotr.hadala.buy4wheelsauth.application.dtos.TokenResponseDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyRequestDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyResponseDTO;

public interface TokeService {
    TokenResponseDTO getToken();

    TokenVerifyResponseDTO verifyToken(TokenVerifyRequestDTO requestDTO);
}
