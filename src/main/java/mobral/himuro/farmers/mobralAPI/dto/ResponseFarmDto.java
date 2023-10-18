package mobral.himuro.farmers.mobralAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mobral.himuro.farmers.mobralAPI.domain.Farm;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFarmDto {
    private Farm farm;
    private List<FieldDto> fields;
}
