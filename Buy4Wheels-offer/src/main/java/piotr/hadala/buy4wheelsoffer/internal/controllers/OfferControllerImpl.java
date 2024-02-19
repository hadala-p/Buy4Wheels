package piotr.hadala.buy4wheelsoffer.internal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import piotr.hadala.buy4wheelsoffer.application.controllers.OfferController;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;
import piotr.hadala.buy4wheelsoffer.internal.services.OfferService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class OfferControllerImpl implements OfferController {
    private final OfferService offerService;

    @Override
    public ResponseEntity<OfferResponseDTO> createOffer(OfferCreateRequestDTO body) {
        return ResponseEntity.ok(offerService.createOffer(body));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffers() {
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @Override
    public ResponseEntity<OfferResponseDTO> getOfferById(UUID id) {
        return ResponseEntity.ok(offerService.getOfferById(id));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByModelName(String modelName) {
        return ResponseEntity.ok(offerService.getOffersByModelName(modelName));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByBrandName(String brandName) {
        return ResponseEntity.ok(offerService.getOffersByBrandName(brandName));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByYear(int year) {
        return ResponseEntity.ok(offerService.getOffersByYear(year));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByPriceRange(double min, double max) {
        return ResponseEntity.ok(offerService.getOffersByPriceRange(min, max));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByMileage(int max) {
        return ResponseEntity.ok(offerService.getOffersByMileage(max));
    }
    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByFuelType(String fuelType) {
        return ResponseEntity.ok(offerService.getOffersByFuelType(fuelType));
    }
    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByTransmission(String transmission) {
        return ResponseEntity.ok(offerService.getOffersByTransmission(transmission));
    }

    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByEnginePowerRange(int min, int max) {
        return ResponseEntity.ok(offerService.getOffersByEnginePowerRange(min, max));
    }
    @Override
    public ResponseEntity<OfferListResponseDTO> getOffersByColor(String color) {
        return ResponseEntity.ok(offerService.getOffersByColor(color));
    }
}
