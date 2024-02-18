package piotr.hadala.buy4wheelsoffer.application.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OfferListResponseDTO {
    private List<OfferResponseDTO> offers;
}
