package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandSimpleDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelResponseDTO {
    private int id;
    private String name;
    private BrandSimpleDTO brand;
    private String description;


}
