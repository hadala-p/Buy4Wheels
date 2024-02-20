package piotr.hadala.buy4wheelscar.internal.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.models.ModelResponseDTO;
import piotr.hadala.buy4wheelscar.internal.services.ModelService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ModelControllerImplTest {

    private MockMvc mockMvc;

    @Mock
    private ModelService modelService;

    @InjectMocks
    private ModelControllerImpl modelController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(modelController).build();
    }

    @Test
    public void createModel_should_return_created_model() throws Exception {
        // Given
        ModelCreateRequestDTO requestDTO
                = new ModelCreateRequestDTO("ModelName", 1, "ModelDescription");
        ModelResponseDTO responseDTO
                = new ModelResponseDTO(1, "ModelName", null, "ModelDescription");

        when(modelService.createModel(any(ModelCreateRequestDTO.class))).thenReturn(responseDTO);

        // When & Then
        mockMvc.perform(post("/models")
                        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"ModelName\",\"brandId\":1,\"description\":\"ModelDescription\"}"))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.id")
                        .value(1)).andExpect(jsonPath("$.name")
                        .value("ModelName"))
                .andExpect(jsonPath("$.description")
                        .value("ModelDescription"));
    }

    @Test
    public void getModelById_should_return_model() throws Exception {
        // Given
        int modelId = 1;
        ModelResponseDTO responseDTO = new ModelResponseDTO(modelId, "ModelName", null, "ModelDescription");

        when(modelService.getModelById(modelId)).thenReturn(responseDTO);

        // When & Then
        mockMvc.perform(get("/models/{id}", modelId)).andExpect(status()
                .isOk())
                .andExpect(jsonPath("$.id")
                .value(modelId))
                .andExpect(jsonPath("$.name")
                .value("ModelName"))
                .andExpect(jsonPath("$.description")
                        .value("ModelDescription"));
    }

    @Test
    public void getModels_should_return_model_list() throws Exception {
        // Given
        ModelListResponseDTO listResponseDTO = new ModelListResponseDTO();

        when(modelService.getModels()).thenReturn(listResponseDTO);

        // When & Then
        mockMvc.perform(get("/models")).andExpect(status().isOk());
    }

    @Test
    public void deleteModelById_should_return_no_content() throws Exception {
        // Given
        int modelId = 1;
        doNothing().when(modelService).deleteModelById(modelId);

        // When & Then
        mockMvc.perform(delete("/models/{id}", modelId)).andExpect(status().isNoContent());
    }
}
