package mobral.himuro.farmers.mobralAPI.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeatureJson {
    @JsonProperty("type")
    private String type;
    @JsonProperty("properties")
    private PropertiesJson properties;
    @JsonProperty("geometry")
    private GeometryJson geometry;
}
