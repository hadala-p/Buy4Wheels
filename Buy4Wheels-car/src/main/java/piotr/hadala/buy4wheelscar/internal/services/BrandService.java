package piotr.hadala.buy4wheelscar.internal.services;

import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;

public interface BrandService {
    BrandResponseDTO createBrand(BrandCreateRequestDTO brandCreateRequestDTO);

    BrandListResponseDTO getBrands();

    BrandResponseDTO getBrandById(int id);
}
