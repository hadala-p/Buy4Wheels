package piotr.hadala.buy4wheelslib.commondto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ViolationDto {
    private String fieldName;
    private String message;
}
