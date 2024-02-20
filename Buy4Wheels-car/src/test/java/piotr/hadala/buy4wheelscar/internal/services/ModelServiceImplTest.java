package piotr.hadala.buy4wheelscar.internal.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelscar.internal.entities.ModelEntity;
import piotr.hadala.buy4wheelscar.internal.mappers.ModelMapper;
import piotr.hadala.buy4wheelscar.internal.repositories.BrandRepository;
import piotr.hadala.buy4wheelscar.internal.repositories.ModelRepository;
import piotr.hadala.buy4wheelslib.exceptions.EntityNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModelServiceImplTest {

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private ModelServiceImpl modelService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_create_model_successfully() {
        // Given
        ModelCreateRequestDTO requestDTO
                = new ModelCreateRequestDTO("ModelName", 1, "ModelDescription");

        BrandEntity brandEntity
                = new BrandEntity(1, "BrandName", "Country", "Description", null);

        ModelEntity modelEntity
                = new ModelEntity(1, "ModelName", brandEntity, "ModelDescription");

        ModelResponseDTO expectedResponse
                = new ModelResponseDTO(1, "ModelName", null, "ModelDescription");

        when(brandRepository.findById(anyInt())).thenReturn(Optional.of(brandEntity));
        when(modelMapper.toEntity(any(ModelCreateRequestDTO.class))).thenReturn(modelEntity);
        when(modelRepository.save(any(ModelEntity.class))).thenReturn(modelEntity);
        when(modelMapper.toResponse(any(ModelEntity.class))).thenReturn(expectedResponse);

        // When
        ModelResponseDTO actualResponse = modelService.createModel(requestDTO);

        // Then
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void should_throw_EntityNotFoundException_when_brand_not_found() {
        // Given
        ModelCreateRequestDTO requestDTO
                = new ModelCreateRequestDTO("ModelName", -1, "ModelDescription");

        when(brandRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When & Then
        assertThatThrownBy(() -> modelService.createModel(requestDTO))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Brand not found with id: -1");
    }

    @Test
    void should_get_model_by_id_successfully() {
        // Given
        int modelId = 1;
        ModelEntity modelEntity
                = new ModelEntity(modelId, "ModelName", null, "ModelDescription");
        ModelResponseDTO expectedResponse
                = new ModelResponseDTO(modelId, "ModelName", null, "ModelDescription");

        when(modelRepository.findById(modelId)).thenReturn(Optional.of(modelEntity));
        when(modelMapper.toResponse(modelEntity)).thenReturn(expectedResponse);

        // When
        ModelResponseDTO actualResponse = modelService.getModelById(modelId);

        // Then
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void should_throw_EntityNotFoundException_when_model_not_found() {
        // Given
        int modelId = -1;

        when(modelRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When & Then
        assertThatThrownBy(() -> modelService.getModelById(modelId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Model not found with id: -1");
    }

    @Test
    void should_delete_model_by_id_successfully() {
        // Given
        int modelId = 1;
        ModelEntity modelEntity = new ModelEntity(modelId, "ModelName", null, "ModelDescription");

        when(modelRepository.findById(modelId)).thenReturn(Optional.of(modelEntity));
        doNothing().when(modelRepository).delete(any(ModelEntity.class));

        // When
        modelService.deleteModelById(modelId);

        // Then
        verify(modelRepository, times(1)).delete(modelEntity);
    }

    @Test
    void should_throw_EntityNotFoundException_when_deleting_nonexistent_model() {
        // Given
        int modelId = -1;

        when(modelRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When & Then
        assertThatThrownBy(() -> modelService.deleteModelById(modelId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Model not found with id: -1");
    }
}
