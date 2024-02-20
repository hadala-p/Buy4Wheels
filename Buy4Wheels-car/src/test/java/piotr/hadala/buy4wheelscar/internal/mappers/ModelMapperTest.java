package piotr.hadala.buy4wheelscar.internal.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelscar.internal.entities.ModelEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ModelMapperTest {

    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        modelMapper = Mappers.getMapper(ModelMapper.class);
    }

    @Test
    public void should_map_ModelCreateRequestDTO_to_ModelEntity() {
        // Given
        ModelCreateRequestDTO modelCreateRequestDTO = new ModelCreateRequestDTO("ModelName", 1, "ModelDescription");

        // When
        ModelEntity modelEntity = modelMapper.toEntity(modelCreateRequestDTO);

        // Then
        assertNotNull(modelEntity);
        assertEquals(modelCreateRequestDTO.getName(), modelEntity.getName());
        assertEquals(modelCreateRequestDTO.getDescription(), modelEntity.getDescription());
        // The ID and Brand should not be set as they are ignored in the mapping
        assertEquals(0, modelEntity.getId());
        assertEquals(null, modelEntity.getBrand());
    }

    @Test
    public void should_map_ModelEntityList_to_ModelListResponseDTO() {
        // Given
        BrandEntity brandEntity = new BrandEntity(1, "BrandName", "Country", "Description", null);
        ModelEntity modelEntity = new ModelEntity(1, "ModelName", brandEntity, "ModelDescription");
        List<ModelEntity> modelEntityList = Collections.singletonList(modelEntity);

        // When
        ModelListResponseDTO modelListResponseDTO = modelMapper.toResponse(modelEntityList);

        // Then
        assertNotNull(modelListResponseDTO);
        assertNotNull(modelListResponseDTO.getModels());
        assertEquals(1, modelListResponseDTO.getModels().size());
        assertEquals(modelEntity.getName(), modelListResponseDTO.getModels().get(0).getName());
        assertEquals(modelEntity.getDescription(), modelListResponseDTO.getModels().get(0).getDescription());
    }
}
