package piotr.hadala.buy4wheelsoffer.internal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import piotr.hadala.buy4wheelslib.entities.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offer")
public class OfferEntity extends BaseEntity {

    @Column
    private int brandId;
    @Column
    private int modelId;
    @Column
    private int year;
    @Column
    private double mileage;
    @Column
    private String fuelType;
    @Column
    private String transmission;
    @Column
    private int enginePower;
    @Column
    private String color;
    @Column
    private double price;
    @Column
    private String description;
    @Column
    private boolean isAvailable;
}
