package piotr.hadala.buy4wheelscar.application.dtos.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ModelCreateRequestDTO {
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
    @NotNull
    private int brandId;
    @NotNull
    @Size(min = 1, max = 255)
    private String description;

}
