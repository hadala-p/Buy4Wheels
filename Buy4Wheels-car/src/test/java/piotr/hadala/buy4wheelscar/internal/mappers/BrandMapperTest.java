package piotr.hadala.buy4wheelscar.internal.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BrandMapperTest {

    private BrandMapper brandMapper;

    @BeforeEach
    public void setUp() {
        brandMapper = Mappers.getMapper(BrandMapper.class);
    }

    @Test
    public void shouldMapBrandEntityToBrandResponseDTO() {
        // Given
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(1);
        brandEntity.setName("BrandName");
        brandEntity.setCountry("CountryName");
        brandEntity.setDescription("BrandDescription");

        // When
        BrandResponseDTO brandResponseDTO = brandMapper.toResponse(brandEntity);

        // Then
        assertNotNull(brandResponseDTO);
        assertEquals(brandEntity.getId(), brandResponseDTO.getId());
        assertEquals(brandEntity.getName(), brandResponseDTO.getName());
        assertEquals(brandEntity.getCountry(), brandResponseDTO.getCountry());
        assertEquals(brandEntity.getDescription(), brandResponseDTO.getDescription());
    }

    @Test
    public void shouldMapBrandCreateRequestDTOToBrandEntity() {
        // Given
        BrandCreateRequestDTO brandCreateRequestDTO = new BrandCreateRequestDTO();
        brandCreateRequestDTO.setName("BrandName");
        brandCreateRequestDTO.setCountry("CountryName");
        brandCreateRequestDTO.setDescription("BrandDescription");

        // When
        BrandEntity brandEntity = brandMapper.toEntity(brandCreateRequestDTO);

        // Then
        assertNotNull(brandEntity);
        assertEquals(brandCreateRequestDTO.getName(), brandEntity.getName());
        assertEquals(brandCreateRequestDTO.getCountry(), brandEntity.getCountry());
        assertEquals(brandCreateRequestDTO.getDescription(), brandEntity.getDescription());
    }

    @Test
    public void shouldMapBrandEntityListToBrandListResponseDTO() {
        // Given
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(1);
        brandEntity.setName("BrandName");
        brandEntity.setCountry("CountryName");
        brandEntity.setDescription("BrandDescription");
        List<BrandEntity> brandEntityList = Collections.singletonList(brandEntity);

        // When
        BrandListResponseDTO brandListResponseDTO = brandMapper.toResponse(brandEntityList);

        // Then
        assertNotNull(brandListResponseDTO);
        assertNotNull(brandListResponseDTO.getModels());
        assertEquals(1, brandListResponseDTO.getModels().size());
        assertEquals(brandEntity.getName(), brandListResponseDTO.getModels().get(0).getName());
    }
}
