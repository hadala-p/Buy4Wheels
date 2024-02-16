package piotr.hadala.buy4wheelscar.internal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.ModelEntity;
import piotr.hadala.buy4wheelslib.mappers.MainMapperConfig;

@Mapper(config = MainMapperConfig.class)
public interface ModelMapper {
    ModelResponseDTO toResponse(ModelEntity entity);
    default ModelListResponseDTO toResponse(Page<ModelEntity> entities){
        return new ModelListResponseDTO()
                .setModels(entities.map(this::toResponse).getContent())
                        .setTotalElements(entities.getTotalElements())
                        .setTotalPages(entities.getTotalPages());
    }
    @Mapping(target = "brand", ignore = true)
    @Mapping (target = "id", ignore = true)
    ModelEntity toEntity(ModelCreateRequestDTO dto);
}
