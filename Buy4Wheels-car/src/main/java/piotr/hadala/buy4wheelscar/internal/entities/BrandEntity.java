package piotr.hadala.buy4wheelscar.internal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import piotr.hadala.buy4wheelslib.entities.BaseEntity;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="CarBrand")
public class BrandEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String country;
    @Column
    private String description;
    @OneToMany (mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ModelEntity> models;
}
