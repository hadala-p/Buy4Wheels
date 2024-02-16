package piotr.hadala.buy4wheelscar.application.dtos.models;

import lombok.Data;

import java.util.UUID;

@Data
public class BrandSimpleDTO {
    private UUID id;
    private String name;
}
