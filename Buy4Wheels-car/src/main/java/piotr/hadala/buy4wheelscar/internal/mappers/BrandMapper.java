package piotr.hadala.buy4wheelscar.internal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelslib.mappers.MainMapperConfig;

import java.util.List;

@Mapper(config = MainMapperConfig.class)
public interface BrandMapper {
    BrandResponseDTO toResponse(BrandEntity entity);
    default BrandListResponseDTO toResponse(List<BrandEntity> entities) {
        return new BrandListResponseDTO()
                .setModels(entities.stream().map(this::toResponse).toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "models", ignore = true)
    BrandEntity toEntity(BrandCreateRequestDTO dto);
}
