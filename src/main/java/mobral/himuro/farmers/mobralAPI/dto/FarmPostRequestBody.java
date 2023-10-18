package mobral.himuro.farmers.mobralAPI.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class FarmPostRequestBody {
    @NotEmpty(message = "Field 'nomeFazenda' cannot be empty")
    private String nomeFazenda;
    private Long cdIdUser;
    private FeatureCollectionJson featuresCollection;
}
