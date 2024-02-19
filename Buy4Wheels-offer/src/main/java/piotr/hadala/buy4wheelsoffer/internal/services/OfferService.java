package piotr.hadala.buy4wheelsoffer.internal.services;

import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;

import java.util.UUID;

public interface OfferService {
    OfferResponseDTO createOffer(OfferCreateRequestDTO offerCreateRequestDTO);

    OfferResponseDTO getOfferById(UUID id);

    OfferListResponseDTO getOffersByYear(int year);

    OfferListResponseDTO getOffersByMileage(int max);

    OfferListResponseDTO getOffersByFuelType(String fuelType);

    OfferListResponseDTO getOffersByTransmission(String transmission);

    OfferListResponseDTO getOffersByEnginePowerRange(int min, int max);

    OfferListResponseDTO getAllOffers();
}
