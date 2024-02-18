package piotr.hadala.buy4wheelsoffer.internal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import piotr.hadala.buy4wheelslib.mappers.MainMapperConfig;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;
import piotr.hadala.buy4wheelsoffer.internal.entities.OfferEntity;

import java.util.List;

@Mapper(config = MainMapperConfig.class)
public interface OfferMapper {
    OfferResponseDTO toResponse(OfferEntity entity);


    @Mapping(target = "brandId", ignore = true)
    @Mapping(target = "modelId", ignore = true)
    @Mapping(target = "id", ignore = true)
    OfferEntity toEntity(OfferCreateRequestDTO dto);

    default OfferListResponseDTO toResponse(List<OfferEntity> entities) {
        OfferListResponseDTO response = new OfferListResponseDTO();
        response.setOffers(entities.stream().map(this::toResponse).toList());
        return response;
    }
}
