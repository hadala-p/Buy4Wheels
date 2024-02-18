package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class ModelListResponseDTO {
    int totalPages;
    long totalElements;
    private List<ModelResponseDTO> models;
}
