package piotr.hadala.buy4wheelsoffer.application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferCreateRequestDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferListResponseDTO;
import piotr.hadala.buy4wheelsoffer.application.dtos.OfferResponseDTO;

import java.util.UUID;

public interface OfferController {
    @PostMapping("/offers")
    ResponseEntity<OfferResponseDTO> createOffer(@Valid @RequestBody OfferCreateRequestDTO offerRequestDTO);
    @GetMapping("/offers")
    ResponseEntity<OfferListResponseDTO> getOffers();
    @GetMapping("/offers/{id}")
    ResponseEntity<OfferResponseDTO> getOfferById(@Valid @RequestParam UUID id);
//    @GetMapping("/offers/models/{modelName}")
//    ResponseEntity<OfferListResponseDTO> getOffersByModelName(@Valid @PathVariable String modelName);
//    @GetMapping("/offers/brands/{brandName}")
//    ResponseEntity<OfferListResponseDTO> getOffersByBrandName(@Valid @PathVariable String brandName);
//    @GetMapping("/offers/brands/{brandName}/models/{modelName}")
//    ResponseEntity<OfferListResponseDTO> getOffersByBrandNameAndModelName(@Valid @PathVariable String brandName,
//                                                                      @Valid @PathVariable String modelName);
//    @GetMapping("/offers/brands/{brandName}/models/{modelName}/year/{year}")
//    ResponseEntity<OfferResponseDTO> getOffersByBrandNameAndModelNameAndYear(@Valid @PathVariable String brandName,
//                                                                            @Valid @PathVariable String modelName,
//                                                                            @Valid @PathVariable int year);
    @GetMapping("/offers/years/{year}")
    ResponseEntity<OfferListResponseDTO> getOffersByYear(@Valid @PathVariable int year);
//    @GetMapping("/offers/prices?min={min}&max={max}")
//    ResponseEntity<OfferListResponseDTO> getOffersByPriceRange(@Valid @PathVariable double min,
//                                                           @Valid @PathVariable double max);
    @GetMapping("/offers/mileages")
    ResponseEntity<OfferListResponseDTO> getOffersByMileage(@Valid @RequestParam int max);
    @GetMapping("/offers/fuelTypes/{fuelType}")
    ResponseEntity<OfferListResponseDTO> getOffersByFuelType(@Valid @PathVariable String fuelType);
    @GetMapping("/offers/transmissions/{transmission}")
    ResponseEntity<OfferListResponseDTO> getOffersByTransmission(@Valid @PathVariable String transmission);
    @GetMapping("/offers/enginePowers")
    ResponseEntity<OfferListResponseDTO> getOffersByEnginePowerRange(@Valid @RequestParam int min,
                                                                 @Valid @RequestParam int max);
    @GetMapping("/offers/colors/{color}")
    ResponseEntity<OfferListResponseDTO> getOffersByColor(@Valid @PathVariable String color);
//    @GetMapping("/offers/availability/{isAvailable}")
//    ResponseEntity<OfferListResponseDTO> getOffersByAvailability(@Valid @PathVariable boolean isAvailable);
//    @GetMapping("/offers/search?query={query}")
//    ResponseEntity<OfferResponseDTO> searchOffers(@Valid @PathVariable String query);

}
