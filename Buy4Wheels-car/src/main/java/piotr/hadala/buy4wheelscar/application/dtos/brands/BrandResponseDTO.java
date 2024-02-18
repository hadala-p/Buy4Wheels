package piotr.hadala.buy4wheelscar.application.dtos.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandResponseDTO {
    private int id;
    private String name;
    private String country;
    private String description;

}
