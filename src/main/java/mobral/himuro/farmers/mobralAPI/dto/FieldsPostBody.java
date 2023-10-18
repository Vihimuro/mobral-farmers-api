package mobral.himuro.farmers.mobralAPI.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FieldsPostBody {
    private long cdIdFazenda;
    private FeatureCollectionJson featuresCollection;
}
