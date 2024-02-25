package piotr.hadala.buy4wheelsoffer.internal.services;

import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferSearchParamsDTO;

import java.util.UUID;

public interface OfferService {
    OfferResponseDTO createOffer(OfferCreateRequestDTO offerCreateRequestDTO);

    OfferResponseDTO getOfferById(UUID id);

    OfferListResponseDTO getOffersByYear(int year);

    OfferListResponseDTO getOffersByModelName(String modelName);

    OfferListResponseDTO getOffersByBrandName(String brandName);

    OfferListResponseDTO getOffersByBrandNameAndModelName(String brandName, String modelName);

    OfferListResponseDTO getOffersByPriceRange(double min, double max);

    OfferListResponseDTO getOffersByMileage(int max);

    OfferListResponseDTO getOffersByFuelType(String fuelType);

    OfferListResponseDTO getOffersByTransmission(String transmission);

    OfferListResponseDTO getOffersByEnginePowerRange(int min, int max);

    OfferListResponseDTO getOffersByColor(String color);

    OfferListResponseDTO getOffersByAvailability(boolean isAvailable);

    OfferListResponseDTO getOffersByParams(OfferSearchParamsDTO params);

    void deleteOfferById(UUID id);
}
