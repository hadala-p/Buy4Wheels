package piotr.hadala.buy4wheelsoffer.internal.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;
import piotr.hadala.buy4wheelsoffer.internal.entities.OfferEntity;
import piotr.hadala.buy4wheelsoffer.internal.mappers.OfferMapper;
import piotr.hadala.buy4wheelsoffer.internal.repositories.OfferRepository;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OfferServiceImpl implements OfferService{
    private final OfferMapper mapper;
    private final OfferRepository repository;

    @Override
    public OfferResponseDTO createOffer(OfferCreateRequestDTO offerCreateRequestDTO) {
        OfferEntity offerEntity = mapper.toEntity(offerCreateRequestDTO);
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
