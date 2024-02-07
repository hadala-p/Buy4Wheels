package piotr.hadala.userservice.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMinimalDto {
    private Long id;
    private String email;

    public UserMinimalDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}

