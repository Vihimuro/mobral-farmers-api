package mobral.himuro.farmers.mobralAPI.dto;

import lombok.*;
import mobral.himuro.farmers.mobralAPI.domain.Farm;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseFarmDto {
    private Farm farm;
    private List<FieldDto> fields;
}
