package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelResponseDTO {
    private UUID id;
    private String name;
    private BrandSimpleDTO brand;
    private String description;



}
