package piotr.hadala.buy4wheelscar.internal.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;


    @Test
    public void should_find_all_brands() {
        // Given
        BrandEntity brand = new BrandEntity();
        brand.setName("TestBrand");
        brand.setCountry("TestCountry");
        brand.setDescription("TestDescription");
        brandRepository.save(brand);

        // When
        Iterable<BrandEntity> brands = brandRepository.findAll();

        // Then
        assertThat(brands).isNotEmpty();
    }
    @Test
    public void should_delete_brand_successfully() {
        // Given
        BrandEntity brand = new BrandEntity(1, "BrandToDelete", "TestCountry", "TestDescription", null);
        brandRepository.save(brand);

        // When
        brandRepository.delete(brand);
        List<BrandEntity> brands = brandRepository.findAll();

        // Then
        assertThat(brands).doesNotContain(brand);
    }

}
