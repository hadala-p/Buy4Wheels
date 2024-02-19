package piotr.hadala.buy4wheelsoffer.internal.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;
import piotr.hadala.buy4wheelsoffer.internal.client.BrandClient;
import piotr.hadala.buy4wheelsoffer.internal.client.ModelClient;
import piotr.hadala.buy4wheelsoffer.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelsoffer.internal.entities.ModelEntity;
import piotr.hadala.buy4wheelsoffer.internal.entities.OfferEntity;
import piotr.hadala.buy4wheelsoffer.internal.mappers.OfferMapper;
import piotr.hadala.buy4wheelsoffer.internal.repositories.OfferRepository;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OfferServiceImpl implements OfferService{
    private final OfferMapper mapper;
    private final OfferRepository repository;
    private final BrandClient brandClient;
    private final ModelClient modelClient;

    @Override
    public OfferResponseDTO createOffer(OfferCreateRequestDTO offerCreateRequestDTO) {
        OfferEntity offerEntity = mapper.toEntity(offerCreateRequestDTO);

        BrandResponseDTO brandResponseDTO = brandClient.getBrandById(offerCreateRequestDTO.getBrandId()).getBody();
        ModelResponseDTO modelResponseDTO = modelClient.getModelById(offerCreateRequestDTO.getModelId()).getBody();

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(brandResponseDTO.getId());
        brandEntity.setName(brandResponseDTO.getName());

        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setId(modelResponseDTO.getId());
        modelEntity.setName(modelResponseDTO.getName());

        offerEntity.setBrand(brandEntity);
        offerEntity.setModel(modelEntity);

        OfferEntity persistedOffer = repository.save(offerEntity);
        return mapper.toResponse(persistedOffer);
    }

    @Override
    public OfferResponseDTO getOfferById(UUID id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Offer not found with id: " + id));
    }

    @Override
    public OfferListResponseDTO getAllOffers() {
        return mapper.toResponse(repository.findAll());
    }
}
