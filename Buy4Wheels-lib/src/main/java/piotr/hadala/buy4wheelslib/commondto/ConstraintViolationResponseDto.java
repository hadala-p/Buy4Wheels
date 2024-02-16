package piotr.hadala.buy4wheelslib.commondto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class ConstraintViolationResponseDto {
    private List<ViolationDto> violations;
}