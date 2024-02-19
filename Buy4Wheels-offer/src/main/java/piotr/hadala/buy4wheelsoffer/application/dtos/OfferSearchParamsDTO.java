package piotr.hadala.buy4wheelsoffer.application.dtos;

import lombok.Data;

@Data
public class OfferSearchParamsDTO {
    private String brand;
    private String model;
    private Integer year;
    private double price;
    private Integer mileage;
    private String engine;
    private String fuel;
    private Integer power;
    private String gearbox;
}
