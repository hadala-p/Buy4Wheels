package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.Data;

@Data
public class ModelSearchParamsDTO {
    private String searchString;
    private int pageNumber;
    private int pageSize;
}
