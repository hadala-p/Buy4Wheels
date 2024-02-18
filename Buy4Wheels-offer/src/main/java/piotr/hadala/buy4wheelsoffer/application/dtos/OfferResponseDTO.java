package piotr.hadala.buy4wheelsoffer.application.dtos;

import lombok.Data;
import piotr.hadala.buy4wheelscar.application.dtos.models.BrandSimpleDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelSimpleDTO;

import java.util.UUID;
@Data
public class OfferResponseDTO {
    private UUID id;
    private BrandSimpleDTO brand;
    private ModelSimpleDTO model;
    private int year;
    private double mileage;
    private String fuelType;
    private String transmission;
    private int enginePower;
    private String color;
    private double price;
    private String description;
    private boolean isAvailable;



}
