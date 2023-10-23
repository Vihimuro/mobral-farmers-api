package mobral.himuro.farmers.mobralAPI.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeatureCollectionJson {
    @JsonProperty("type")
    private String type;
    @JsonProperty("features")
    private ArrayList<FeatureJson> features;
}
