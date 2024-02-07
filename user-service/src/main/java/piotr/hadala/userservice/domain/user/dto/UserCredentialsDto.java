package piotr.hadala.userservice.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class UserCredentialsDto {
    private final String email;
    private final String password;
    private final Set<String> roles;

    public UserCredentialsDto(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
