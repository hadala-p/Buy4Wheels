package piotr.hadala.buy4wheelscar.internal.services;

import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;

public interface ModelService {
    ModelResponseDTO createModel(ModelCreateRequestDTO body);

    ModelListResponseDTO getModels();

    ModelResponseDTO getModelById(int id);

    void deleteModelById(int id);

}
