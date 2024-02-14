package piotr.hadala.buy4wheelsauth.security;

import org.springframework.security.core.AuthenticationException;

class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}