package piotr.hadala.buy4wheelscar.internal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import piotr.hadala.buy4wheelslib.entities.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="CarModel")
public class ModelEntity extends BaseEntity {
    @Column
    private String name;
    @JoinColumn(name = "brand_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private BrandEntity brand;
    @Column
    private String description;
}
