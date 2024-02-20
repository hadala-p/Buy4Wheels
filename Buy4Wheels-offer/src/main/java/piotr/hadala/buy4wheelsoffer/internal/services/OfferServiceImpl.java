package piotr.hadala.buy4wheelsoffer.internal.services;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelslib.exceptions.EntityNotFoundException;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferSearchParamsDTO;
import piotr.hadala.buy4wheelsoffer.internal.client.BrandClient;
import piotr.hadala.buy4wheelsoffer.internal.client.ModelClient;
import piotr.hadala.buy4wheelsoffer.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelsoffer.internal.entities.ModelEntity;
import piotr.hadala.buy4wheelsoffer.internal.entities.OfferEntity;
import piotr.hadala.buy4wheelsoffer.internal.mappers.OfferMapper;
import piotr.hadala.buy4wheelsoffer.internal.repositories.OfferRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {
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
        return repository.findById(id).map(mapper::toResponse).orElseThrow(() -> new EntityNotFoundException("Offer not found with id: " + id));
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
    public OfferListResponseDTO getOffersByBrandName(String brandName) {
        List<OfferEntity> offers = repository.findAllByBrand_Name(brandName);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with brand name: " + brandName);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByBrandNameAndModelName(String brandName, String modelName) {
        List<OfferEntity> offers = repository.findAllByBrand_NameAndModel_Name(brandName, modelName);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with brand name: " + brandName + " and model name: " + modelName);
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
    public OfferListResponseDTO getOffersByAvailability(boolean isAvailable) {
        List<OfferEntity> offers = repository.findAllByIsAvailable(isAvailable);
        if (offers.isEmpty()) {
            throw new EntityNotFoundException("Offer not found with availability: " + isAvailable);
        }
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }

    @Override
    public OfferListResponseDTO getOffersByParams(OfferSearchParamsDTO params) {
        int pageNumber = params.getPageNumer() >= 0 ? params.getPageNumer() : 0;
        int pageSize = params.getPageSize() > 0 ? params.getPageSize() : 10;
        Page<OfferEntity> offers = repository.findAll((Specification<OfferEntity>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (params.getBrand() != null) {
                predicates.add(builder.like(root.get("brand").get("name"), "%" + params.getBrand() + "%"));
            }
            if (params.getModel() != null) {
                predicates.add(builder.like(root.get("model").get("name"), "%" + params.getModel() + "%"));
            }
            if (params.getYear() != null) {
                predicates.add(builder.equal(root.get("year"), params.getYear()));
            }
            if (params.getMileage() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("mileage"), params.getMileage()));
            }
            if (params.getFuelType() != null) {
                predicates.add(builder.like(root.get("fuelType"), "%" + params.getFuelType() + "%"));
            }
            if (params.getTransmission() != null) {
                predicates.add(builder.like(root.get("transmission"), "%" + params.getTransmission() + "%"));
            }
            if (params.getPowerMin() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("enginePower"), params.getPowerMin()));
            }
            if (params.getPowerMax() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("enginePower"), params.getPowerMax()));
            }
            if (params.getColor() != null) {
                predicates.add(builder.like(root.get("color"), "%" + params.getColor() + "%"));
            }
            if (params.getPriceMin() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("price"), params.getPriceMin()));
            }
            if (params.getPriceMax() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("price"), params.getPriceMax()));
            }
            if (params.isAvailable()) {
                predicates.add(builder.isTrue(root.get("isAvailable")));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(pageNumber, pageSize));
        OfferListResponseDTO responseDTO = new OfferListResponseDTO();
        responseDTO.setOffers(offers.stream().map(mapper::toResponse).collect(Collectors.toList()));
        return responseDTO;
    }
}
