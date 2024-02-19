package piotr.hadala.buy4wheelsoffer.internal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import piotr.hadala.buy4wheelscar.application.controllers.ModelController;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;

@FeignClient(url = "${apis.buy4wheels-car.url}", name = "model")
public interface ModelClient extends ModelController {
    @GetMapping("/models/{id}")
    ResponseEntity<ModelResponseDTO> getModelById(@PathVariable("id") int id);
}
