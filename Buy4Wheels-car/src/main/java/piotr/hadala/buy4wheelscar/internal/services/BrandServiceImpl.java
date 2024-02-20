package piotr.hadala.buy4wheelscar.internal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import piotr.hadala.buy4wheelslib.exceptions.EntityNotFoundException;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;
import piotr.hadala.buy4wheelscar.internal.mappers.BrandMapper;
import piotr.hadala.buy4wheelscar.internal.repositories.BrandRepository;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;


    @Override
    public BrandResponseDTO createBrand(BrandCreateRequestDTO body) {
        BrandEntity brandEntity = brandMapper.toEntity(body);
        BrandEntity persistEntity = brandRepository.save(brandEntity);
        return brandMapper.toResponse(persistEntity);
    }

    @Override
    public BrandListResponseDTO getBrands() {
        return brandMapper.toResponse(brandRepository.findAll());
    }

    @Override
    public BrandResponseDTO getBrandById(int id) {
        return brandRepository.findById(id).map(brandMapper::toResponse).orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
    }

    @Override
    public void deleteBrandById(int id) {
        BrandEntity brandEntity = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
        brandRepository.delete(brandEntity);
    }
}
