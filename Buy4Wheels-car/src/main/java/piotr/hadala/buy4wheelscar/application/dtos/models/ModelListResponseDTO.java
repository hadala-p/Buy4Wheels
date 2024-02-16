package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class ModelListResponseDTO {
    private List<ModelResponseDTO> models;
    int totalPages;

    long totalElements;
}
