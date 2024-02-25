package piotr.hadala.buy4wheelscar.application.dtos.brands;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BrandListResponseDTOTest {

    @Test
    public void should_correctly_add_and_retrieve_models() {
        // Given: A BrandListResponseDTO and a list of BrandResponseDTOs
        BrandListResponseDTO listResponseDTO = new BrandListResponseDTO();
        List<BrandResponseDTO> brandResponseDTOList = getBrandResponseDTOS();

        // When: Models are added to the list
        listResponseDTO.setBrands(brandResponseDTOList);

        // Then: The retrieved list of models should match the added list
        assertThat(listResponseDTO.getBrands()).isEqualTo(brandResponseDTOList);
    }

    private static List<BrandResponseDTO> getBrandResponseDTOS() {
        List<BrandResponseDTO> brandResponseDTOList = new ArrayList<>();

        BrandResponseDTO brand1 = new BrandResponseDTO();
        BrandResponseDTO brand2 = new BrandResponseDTO();

        brand1.setName("Brand1");
        brand1.setCountry("Country1");
        brand1.setDescription("Description1");

        brand2.setName("Brand2");
        brand2.setCountry("Country2");
        brand2.setDescription("Description2");

        brandResponseDTOList.add(brand1);
        brandResponseDTOList.add(brand2);
        return brandResponseDTOList;
    }

    @Test
    public void should_be_able_to_chain_setters() {
        // Given: A new BrandListResponseDTO and a BrandResponseDTO
        BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
        brandResponseDTO.setName("Brand3");
        brandResponseDTO.setCountry("Country3");
        brandResponseDTO.setDescription("Description3");
        List<BrandResponseDTO> brandResponseDTOList = new ArrayList<>();
        brandResponseDTOList.add(brandResponseDTO);

        // When: Using chain setters to add models
        BrandListResponseDTO listResponseDTO = new BrandListResponseDTO().setBrands(brandResponseDTOList);

        // Then: The object should correctly return the added model
        assertThat(listResponseDTO.getBrands()).containsExactly(brandResponseDTO);
    }
}
