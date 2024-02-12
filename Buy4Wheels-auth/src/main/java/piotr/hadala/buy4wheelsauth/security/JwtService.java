package piotr.hadala.buy4wheelsauth.security;

import org.springframework.security.core.Authentication;
import com.nimbusds.jwt.SignedJWT;
import java.util.List;

public interface JwtService {
    String createSignedJWT(String username, List<String> authorities);
    void verifySignature(SignedJWT signedJWT);
    void verifyExpirationTime(SignedJWT signedJWT);
    Authentication createAuthentication(SignedJWT signedJWT);
}
