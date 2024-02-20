package piotr.hadala.buy4wheelscar.application.dtos.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelCreateRequestDTOTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void should_pass_validation_when_data_is_valid() {
        // Given
        ModelCreateRequestDTO dto = new ModelCreateRequestDTO("ModelName", 1, "ModelDescription");

        // When
        Set<ConstraintViolation<ModelCreateRequestDTO>> violations = validator.validate(dto);

        // Then
        assertTrue(violations.isEmpty());
    }

    @Test
    public void should_fail_validation_when_name_is_empty() {
        // Given
        ModelCreateRequestDTO dto = new ModelCreateRequestDTO("", 1, "ModelDescription");

        // When
        Set<ConstraintViolation<ModelCreateRequestDTO>> violations = validator.validate(dto);

        // Then
        assertEquals(1, violations.size());
    }

    @Test
    public void should_fail_validation_when_description_is_too_long() {
        // Given
        String longDescription = "a".repeat(256); // Creates a string longer than 255 characters
        ModelCreateRequestDTO dto = new ModelCreateRequestDTO("ModelName", 1, longDescription);

        // When
        Set<ConstraintViolation<ModelCreateRequestDTO>> violations = validator.validate(dto);

        // Then
        assertEquals(1, violations.size());
    }
}
