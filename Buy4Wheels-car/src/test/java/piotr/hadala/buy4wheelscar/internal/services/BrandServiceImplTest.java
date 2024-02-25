package piotr.hadala.buy4wheelscar.internal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelscar.internal.mappers.BrandMapper;
import piotr.hadala.buy4wheelscar.internal.repositories.BrandRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BrandServiceImplTest {

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandMapper brandMapper;

    @InjectMocks
    private BrandServiceImpl brandService;

    @Test
    public void createBrand_should_return_BrandResponseDTO() {
        // Given
        BrandCreateRequestDTO createRequestDTO = new BrandCreateRequestDTO("BrandName", "Country", "Description");
        BrandEntity brandEntity = new BrandEntity(1, "BrandName", "Country", "Description", null);
        BrandResponseDTO expectedResponse = new BrandResponseDTO(1, "BrandName", "Country", "Description");

        when(brandMapper.toEntity(any(BrandCreateRequestDTO.class))).thenReturn(brandEntity);
        when(brandRepository.save(any(BrandEntity.class))).thenReturn(brandEntity);
        when(brandMapper.toResponse(any(BrandEntity.class))).thenReturn(expectedResponse);

        // When
        BrandResponseDTO response = brandService.createBrand(createRequestDTO);

        // Then
        assertThat(response).isEqualTo(expectedResponse);
        verify(brandMapper).toEntity(createRequestDTO);
        verify(brandRepository).save(brandEntity);
        verify(brandMapper).toResponse(brandEntity);
    }

    @Test
    public void getBrands_should_return_BrandListResponseDTO() {
        // Given
        List<BrandEntity> brandEntities = Collections.singletonList(new BrandEntity(1, "BrandName", "Country", "Description", null));
        BrandListResponseDTO expectedResponse = new BrandListResponseDTO();
        expectedResponse.setBrands(Collections.singletonList(new BrandResponseDTO(1, "BrandName", "Country", "Description")));

        when(brandRepository.findAll()).thenReturn(brandEntities);
        when(brandMapper.toResponse(brandEntities)).thenReturn(expectedResponse);

        // When
        BrandListResponseDTO response = brandService.getBrands();

        // Then
        assertThat(response).isEqualTo(expectedResponse);
        verify(brandRepository).findAll();
        verify(brandMapper).toResponse(brandEntities);
    }

    @Test
    public void getBrandById_should_return_BrandResponseDTO() {
        // Given
        BrandEntity brandEntity = new BrandEntity(1, "BrandName", "Country", "Description", null);
        BrandResponseDTO expectedResponse = new BrandResponseDTO(1, "BrandName", "Country", "Description");

        when(brandRepository.findById(1)).thenReturn(Optional.of(brandEntity));
        when(brandMapper.toResponse(any(BrandEntity.class))).thenReturn(expectedResponse);

        // When
        BrandResponseDTO response = brandService.getBrandById(1);

        // Then
        assertThat(response).isEqualTo(expectedResponse);
        verify(brandRepository).findById(1);
        verify(brandMapper).toResponse(brandEntity);
    }

    @Test
    public void getBrandById_whenBrandNotFound_should_throw_RuntimeException() {
        // Given
        when(brandRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When & Then
        assertThrows(RuntimeException.class, () -> brandService.getBrandById(1));
        verify(brandRepository).findById(1);
    }
}
