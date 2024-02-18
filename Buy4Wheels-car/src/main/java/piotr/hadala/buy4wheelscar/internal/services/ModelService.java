package piotr.hadala.buy4wheelscar.internal.services;

import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelSearchParamsDTO;

import java.util.UUID;

public interface ModelService {
    ModelResponseDTO createModel(ModelCreateRequestDTO body);
    ModelResponseDTO getModelById(int id);
    ModelListResponseDTO getModelsByParams(ModelSearchParamsDTO params);

    void deleteModelById(int id);

}
