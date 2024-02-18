package piotr.hadala.buy4wheelscar.internal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelscar.internal.entities.ModelEntity;
import piotr.hadala.buy4wheelscar.internal.mappers.ModelMapper;
import piotr.hadala.buy4wheelscar.internal.repositories.BrandRepository;
import piotr.hadala.buy4wheelscar.internal.repositories.ModelRepository;
import piotr.hadala.buy4wheelslib.exceptions.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;

    @Override
    public ModelResponseDTO createModel(ModelCreateRequestDTO body) {
        ModelEntity modelEntity = modelMapper.toEntity(body);
        BrandEntity brandEntity = brandRepository.findById(body.getBrandId()).orElseThrow(() -> new EntityNotFoundException(BrandEntity.class, body.getBrandId()));
        modelEntity.setBrand(brandEntity);
        ModelEntity persistEntity = modelRepository.save(modelEntity);
        return modelMapper.toResponse(persistEntity);

    }

    @Override
    public ModelListResponseDTO getModels() {
        return modelMapper.toResponse(modelRepository.findAll());
    }

    @Override
    public ModelResponseDTO getModelById(int id) {
        return modelRepository.findById(id).map(modelMapper::toResponse).orElseThrow(() -> new EntityNotFoundException(ModelEntity.class, id));
    }

    @Override
    public void deleteModelById(int id) {
        ModelEntity modelEntity = modelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ModelEntity.class, id));
        modelRepository.delete(modelEntity);

    }
}
