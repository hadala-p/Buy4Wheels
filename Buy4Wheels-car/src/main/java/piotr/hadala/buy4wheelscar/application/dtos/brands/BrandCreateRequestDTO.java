package piotr.hadala.buy4wheelscar.application.dtos.brands;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandCreateRequestDTO {
    @NotNull
    @Size(min=1, max=20)
    private String name;
    @NotNull
    @Size(min=3, max=30)
    private String country;
    @NotNull
    @Size(min=1, max=255)
    private String description;
}
