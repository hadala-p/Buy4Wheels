package piotr.hadala.buy4wheelscar.application.dtos.brands;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandCreateRequestDTO {
    @NotNull
    @Size(min = 1, max = 20)
    private String name;
    @NotNull
    @Size(min = 3, max = 30)
    private String country;
    @NotNull
    @Size(min = 1, max = 255)
    private String description;
}
