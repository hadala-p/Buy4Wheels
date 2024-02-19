package piotr.hadala.buy4wheelsoffer.application.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(1900)
    @Max(20100)
    private int year;
    @NotNull
    @Min(1)
    @Max(1000000)
    private int mileage;
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
