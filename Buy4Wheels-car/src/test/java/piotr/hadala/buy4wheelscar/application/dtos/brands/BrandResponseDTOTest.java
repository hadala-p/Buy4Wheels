package piotr.hadala.buy4wheelscar.application.dtos.brands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BrandResponseDTOTest {

    @Test
    public void test_getters_and_setters() {
        // Given
        BrandResponseDTO dto = new BrandResponseDTO();
        dto.setId(1);
        dto.setName("TestBrand");
        dto.setCountry("TestCountry");
        dto.setDescription("TestDescription");

        // When - no action needed as we are testing getters

        // Then
        assertEquals(1, dto.getId());
        assertEquals("TestBrand", dto.getName());
        assertEquals("TestCountry", dto.getCountry());
        assertEquals("TestDescription", dto.getDescription());
    }

    @Test
    public void test_equals() {
        // Given
        BrandResponseDTO dto1 = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");
        BrandResponseDTO dto2 = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");

        // When & Then
        assertEquals(dto1, dto2);
    }

    @Test
    public void test_hash_code() {
        // Given
        BrandResponseDTO dto1 = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");
        BrandResponseDTO dto2 = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");

        // When & Then
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void test_not_equals_due_to_different_id() {
        // Given
        BrandResponseDTO dto1 = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");
        BrandResponseDTO dto2 = new BrandResponseDTO(2, "TestBrand", "TestCountry", "TestDescription");

        // When & Then
        assertNotEquals(dto1, dto2);
    }
}
