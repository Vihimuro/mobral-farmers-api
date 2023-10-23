package mobral.himuro.farmers.mobralAPI.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FieldsPostBody {
    @JsonProperty("cdIdFazenda")
    private long cdIdFazenda;
    @JsonProperty("featureCollection")
    private FeatureCollectionJson featureCollection;
}
