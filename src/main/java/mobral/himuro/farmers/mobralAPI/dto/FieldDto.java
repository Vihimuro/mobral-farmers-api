package mobral.himuro.farmers.mobralAPI.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FieldDto implements Serializable {
    private long id;
    private long cdIdFarm;
    private GeometryJson geom;
}
