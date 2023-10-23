package mobral.himuro.farmers.mobralAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseFarmDto {
    @JsonProperty("cd_id_user")
    private long cdIdUser;
    @JsonProperty("featureCollection")
    private FeatureCollectionJson featureCollectionJson;
}
