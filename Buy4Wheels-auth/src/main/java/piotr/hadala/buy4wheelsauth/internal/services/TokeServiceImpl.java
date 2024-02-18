package piotr.hadala.buy4wheelsauth.internal.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenResponseDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyRequestDTO;
import piotr.hadala.buy4wheelsauth.application.dtos.TokenVerifyResponseDTO;
import piotr.hadala.buy4wheelsauth.internal.config.JWTConfig;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokeServiceImpl implements TokeService {
    private final JWTConfig jwtConfig;

    @Override
    public TokenResponseDTO getToken() {
        return new TokenResponseDTO(generateToken());
    }

    @Override
    public TokenVerifyResponseDTO verifyToken(TokenVerifyRequestDTO requestDTO) {
        return new TokenVerifyResponseDTO(validateToken(requestDTO.getToken()));
    }

    private boolean validateToken(String token) {
        long now = System.currentTimeMillis();
        try {
            Claims payload = Jwts
                    .parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return payload.getExpiration().getTime() > now && payload.getIssuedAt().getTime() < now;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    public String generateToken() {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(now + jwtConfig.getExpiration()))
                .signWith(getKey())
                .compact();

    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(jwtConfig.getSecretBytes());
    }
}
