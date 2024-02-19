package piotr.hadala.buy4wheelsoffer.internal.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelslib.exceptions.EntityNotFoundException;
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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public OfferListResponseDTO getOffersByYear(int year) {
        List<OfferEntity> offers = repository.findAllByYear(year);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with year: " + year);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByModelName(String modelName) {
        List<OfferEntity> offers = repository.findAllByModel_Name(modelName);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with model name: " + modelName);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByPriceRange(double min, double max) {
        List<OfferEntity> offers = repository.findAllByPriceBetween(min, max);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with price between: " + min + " and " + max);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByMileage(int max) {
        List<OfferEntity> offers = repository.findAllByMileageLessThan(max);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with mileage less than: " + max);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByFuelType(String fuelType) {
        List<OfferEntity> offers = repository.findAllByFuelType(fuelType);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with fuel type: " + fuelType);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByTransmission(String transmission) {
        List<OfferEntity> offers = repository.findAllByTransmission(transmission);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with transmission: " + transmission);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByEnginePowerRange(int min, int max) {
        List<OfferEntity> offers = repository.findAllByEnginePowerBetween(min, max);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with engine power between: " + min + " and " + max);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByColor(String color) {
        List<OfferEntity> offers = repository.findAllByColor(color);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with color: " + color);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }


    @Override
    public OfferListResponseDTO getAllOffers() {
        return mapper.toResponse(repository.findAll());
    }
}
