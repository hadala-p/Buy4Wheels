package piotr.hadala.buy4wheelsoffer.internal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import piotr.hadala.buy4wheelscar.application.controllers.BrandController;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;

@FeignClient(url = "${apis.buy4wheels-car.url}", name = "brand")
public interface BrandClient extends BrandController {
    @GetMapping("/brands/{id}")
    ResponseEntity<BrandResponseDTO> getBrandById(@PathVariable("id") int id);
}
