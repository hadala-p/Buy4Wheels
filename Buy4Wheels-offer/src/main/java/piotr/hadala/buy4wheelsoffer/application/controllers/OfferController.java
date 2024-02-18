package piotr.hadala.buy4wheelsoffer.application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    ResponseEntity<OfferResponseDTO> getOfferById(@Valid @PathVariable UUID id);
//    @GetMapping("/offers/models/{modelName}")
//    ResponseEntity<OfferResponseDTO> getOffersByModelName(@Valid @PathVariable String modelName);
//    @GetMapping("/offers/brands/{brandName}")
//    ResponseEntity<OfferResponseDTO> getOffersByBrandName(@Valid @PathVariable String brandName);
//    @GetMapping("/offers/brands/{brandName}/models/{modelName}")
//    ResponseEntity<OfferResponseDTO> getOffersByBrandNameAndModelName(@Valid @PathVariable String brandName,
//                                                                      @Valid @PathVariable String modelName);
//    @GetMapping("/offers/brands/{brandName}/models/{modelName}/year/{year}")
//    ResponseEntity<OfferResponseDTO> getOffersByBrandNameAndModelNameAndYear(@Valid @PathVariable String brandName,
//                                                                            @Valid @PathVariable String modelName,
//                                                                            @Valid @PathVariable int year);
//    @GetMapping("/offers/years/{year}")
//    ResponseEntity<OfferResponseDTO> getOffersByYear(@Valid @PathVariable int year);
//    @GetMapping("/offers/prices?min={min}&max={max}")
//    ResponseEntity<OfferResponseDTO> getOffersByPriceRange(@Valid @PathVariable double min,
//                                                           @Valid @PathVariable double max);
//    @GetMapping("/offers/mileages?max={max}")
//    ResponseEntity<OfferResponseDTO> getOffersByMileage(@Valid @PathVariable double max);
//    @GetMapping("/offers/fuelTypes/{fuelType}")
//    ResponseEntity<OfferResponseDTO> getOffersByFuelType(@Valid @PathVariable String fuelType);
//    @GetMapping("/offers/transmissions/{transmission}")
//    ResponseEntity<OfferResponseDTO> getOffersByTransmission(@Valid @PathVariable String transmission);
//    @GetMapping("/offers/enginePowers?min={min}&max={max}")
//    ResponseEntity<OfferResponseDTO> getOffersByEnginePowerRange(@Valid @PathVariable int min,
//                                                                 @Valid @PathVariable int max);
//    @GetMapping("/offers/colors/{color}")
//    ResponseEntity<OfferResponseDTO> getOffersByColor(@Valid @PathVariable String color);
//    @GetMapping("/offers/availability/{isAvailable}")
//    ResponseEntity<OfferResponseDTO> getOffersByAvailability(@Valid @PathVariable boolean isAvailable);
//    @GetMapping("/offers/search?query={query}")
//    ResponseEntity<OfferResponseDTO> searchOffers(@Valid @PathVariable String query);

}
