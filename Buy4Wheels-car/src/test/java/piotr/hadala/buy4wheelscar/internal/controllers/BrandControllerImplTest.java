package piotr.hadala.buy4wheelscar.internal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.internal.services.BrandService;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BrandControllerImpl.class)
public class BrandControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandService brandService;

    @Test
    public void createBrand_should_return_brand_response_DTO() throws Exception {
        // Given
        BrandResponseDTO brandResponseDTO = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");
        Mockito.when(brandService.createBrand(any(BrandCreateRequestDTO.class))).thenReturn(brandResponseDTO);

        // When & Then
        mockMvc.perform(post("/brands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"TestBrand\",\"country\":\"TestCountry\",\"description\":\"TestDescription\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("TestBrand"))
                .andExpect(jsonPath("$.country").value("TestCountry"))
                .andExpect(jsonPath("$.description").value("TestDescription"));
    }

    @Test
    public void getBrands_should_return_brand_list_response_DTO() throws Exception {
        // Given
        BrandListResponseDTO brandListResponseDTO = new BrandListResponseDTO();
        brandListResponseDTO.setModels(Arrays.asList(new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription")));

        Mockito.when(brandService.getBrands()).thenReturn(brandListResponseDTO);

        // When & Then
        mockMvc.perform(get("/brands"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.models[0].id").value(1))
                .andExpect(jsonPath("$.models[0].name").value("TestBrand"))
                .andExpect(jsonPath("$.models[0].country").value("TestCountry"))
                .andExpect(jsonPath("$.models[0].description").value("TestDescription"));
    }

    @Test
    public void getBrandById_should_return_brand_response_DTO() throws Exception {
        // Given
        BrandResponseDTO brandResponseDTO = new BrandResponseDTO(1, "TestBrand", "TestCountry", "TestDescription");
        Mockito.when(brandService.getBrandById(1)).thenReturn(brandResponseDTO);

        // When & Then
        mockMvc.perform(get("/brands/{id}", 1)).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.name").value("TestBrand")).andExpect(jsonPath("$.country").value("TestCountry")).andExpect(jsonPath("$.description").value("TestDescription"));
    }
}
