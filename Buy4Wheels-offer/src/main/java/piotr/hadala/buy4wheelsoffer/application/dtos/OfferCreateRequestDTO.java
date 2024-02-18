package piotr.hadala.buy4wheelsoffer.application.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OfferCreateRequestDTO {
    @NotNull
    private int brandId;
    @NotNull
    private int modelId;
    @NotNull
    @Size(min = 4, max = 4)
    private int year;
    @NotNull
    @Size(min = 1)
    private double mileage;
    @Size(min = 1, max = 30)
    private String fuelType;
    @Size(min = 1, max = 30)
    private String transmission;
    @NotNull
    private int enginePower;
    @Size(min = 1, max = 30)
    private String color;
    @NotNull
    private double price;
    @Size(min = 1, max = 255)
    private String description;
    @NotNull
    private boolean isAvailable;


}
