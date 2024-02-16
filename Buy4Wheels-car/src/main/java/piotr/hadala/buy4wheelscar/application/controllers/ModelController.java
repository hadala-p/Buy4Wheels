package piotr.hadala.buy4wheelscar.application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelSearchParamsDTO;

import java.util.UUID;

public interface ModelController {
    @PostMapping("/models")
    ResponseEntity<ModelResponseDTO> createModel(@Valid @RequestBody ModelCreateRequestDTO body);
    @GetMapping("/models/{id}")
    ResponseEntity<ModelResponseDTO> getModelById(@Valid @RequestBody UUID id);
    @GetMapping("/models")
    ResponseEntity<ModelListResponseDTO> getModelsByParams(ModelSearchParamsDTO params);

    @DeleteMapping("/models/{id}")
    ResponseEntity<Void> deleteModelById(@Valid @PathVariable UUID id);
}
