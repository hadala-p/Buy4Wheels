package piotr.hadala.buy4wheelscar.internal.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BrandEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldSaveAndFindBrandEntity() {
        // Given
        BrandEntity brand = new BrandEntity(0, "TestBrand", "TestCountry", "TestDescription", null);
        entityManager.persistAndFlush(brand);

        // When
        BrandEntity foundBrand = entityManager.find(BrandEntity.class, brand.getId());

        // Then
        assertThat(foundBrand).isNotNull();
        assertThat(foundBrand.getName()).isEqualTo("TestBrand");
        assertThat(foundBrand.getCountry()).isEqualTo("TestCountry");
        assertThat(foundBrand.getDescription()).isEqualTo("TestDescription");
    }

    @Test
    @Sql("/test-sql/insert-test-brands.sql") // Sample SQL file for data pre-run
    public void shouldRetrieveBrandWithModels() {
        // When
        BrandEntity brand = entityManager.find(BrandEntity.class, 1);

        // Then
        assertThat(brand).isNotNull();
        assertThat(brand.getModels()).isNotEmpty();
    }
}
