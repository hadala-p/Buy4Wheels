package piotr.hadala.buy4wheelscar.internal.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import piotr.hadala.buy4wheelscar.application.controllers.ModelController;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelSearchParamsDTO;
import piotr.hadala.buy4wheelscar.internal.services.ModelService;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class ModelControllerImpl implements ModelController {
    private final ModelService modelService;

    @Override
    public ResponseEntity<ModelResponseDTO> createModel(ModelCreateRequestDTO body) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelService.createModel(body));
    }

    @Override
    public ResponseEntity<ModelResponseDTO> getModelById(@Valid @PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelService.getModelById(id));
    }

    @Override
    public ResponseEntity<ModelListResponseDTO> getModelsByParams(ModelSearchParamsDTO params) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelService.getModelsByParams(params));
    }

    @Override
    public ResponseEntity<Void> deleteModelById(UUID id) {
        modelService.deleteModelById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
