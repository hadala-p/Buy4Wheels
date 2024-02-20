package piotr.hadala.buy4wheelsoffer.application.dtos;

import lombok.Data;

@Data
public class OfferSearchParamsDTO {
    private String brand;
    private String model;
    private Integer year;
    private Integer mileage;
    private String fuelType;
    private String transmission;
    private Integer powerMin;
    private Integer powerMax;
    private String color;
    private Double priceMin;
    private Double priceMax;
    private boolean isAvailable;
    private int pageNumer;
    private int pageSize;

}
