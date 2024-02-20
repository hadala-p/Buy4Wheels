package piotr.hadala.buy4wheelsoffer.internal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "offer")
public class OfferEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @JoinColumn(name = "brand_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private BrandEntity brand;
    @JoinColumn(name = "model_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private ModelEntity model;
    @Column
    private int year;
    @Column
    private int mileage;
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
