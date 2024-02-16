package piotr.hadala.buy4wheelscar.application.dtos.brands;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class BrandListResponseDTO {
    private List<BrandResponseDTO> models;
}
