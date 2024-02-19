package piotr.hadala.buy4wheelscar.application.dtos.brands;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class BrandResponseDTO {
    private int id;
    private String name;
    private String country;
    private String description;

}
