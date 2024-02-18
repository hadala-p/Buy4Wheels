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
}
