package piotr.hadala.buy4wheelsoffer.internal.services;

import piotr.hadala.buy4wheelsoffer.application.dtos.*;


import java.util.UUID;

public interface OfferService {
    OfferResponseDTO createOffer(OfferCreateRequestDTO offerCreateRequestDTO);
    OfferResponseDTO getOfferById(UUID id);
    OfferListResponseDTO getAllOffers();
}
