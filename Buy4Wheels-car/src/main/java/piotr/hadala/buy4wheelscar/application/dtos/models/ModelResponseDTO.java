package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelResponseDTO {
    private int id;
    private String name;
    private BrandSimpleDTO brand;
    private String description;


}
