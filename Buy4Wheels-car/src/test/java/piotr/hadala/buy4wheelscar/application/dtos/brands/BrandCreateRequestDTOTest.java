package piotr.hadala.buy4wheelscar.application.dtos.brands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandCreateRequestDTOTest {
    private Validator validator;

    @BeforeEach
    public void setup() {
        // Given: Setup validation factory
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_fail_validation_when_name_is_empty() {
        // Given: A brand create request with an empty name
        BrandCreateRequestDTO dto = new BrandCreateRequestDTO("", "Poland", "Some description");

        // When: Validating the DTO
        Set<ConstraintViolation<BrandCreateRequestDTO>> violations = validator.validate(dto);

        // Then: Expect a single constraint violation
        assertEquals(1, violations.size());
    }

    @Test
    public void should_fail_validation_when_country_is_too_short() {
        // Given: A brand create request with a country code that is too short
        BrandCreateRequestDTO dto = new BrandCreateRequestDTO("BrandName", "PL", "Some description");

        // When: Validating the DTO
        Set<ConstraintViolation<BrandCreateRequestDTO>> violations = validator.validate(dto);

        // Then: Expect a single constraint violation
        assertEquals(1, violations.size());
    }

    @Test
    public void should_fail_validation_when_description_is_too_long() {
        // Given: A brand create request with a description longer than 255 characters
        String longDescription = "a".repeat(256);
        BrandCreateRequestDTO dto = new BrandCreateRequestDTO("BrandName", "Poland", longDescription);

        // When: Validating the DTO
        Set<ConstraintViolation<BrandCreateRequestDTO>> violations = validator.validate(dto);

        // Then: Expect a single constraint violation
        assertEquals(1, violations.size());
    }

    @Test
    public void should_pass_validation_when_data_is_valid() {
        // Given: A brand create request with valid data
        BrandCreateRequestDTO dto = new BrandCreateRequestDTO("BrandName", "Poland", "Valid description");

        // When: Validating the DTO
        Set<ConstraintViolation<BrandCreateRequestDTO>> violations = validator.validate(dto);

        // Then: Expect no constraint violations
        assertEquals(0, violations.size());
    }
}
