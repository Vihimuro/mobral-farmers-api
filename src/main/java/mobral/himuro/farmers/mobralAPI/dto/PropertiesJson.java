package mobral.himuro.farmers.mobralAPI.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PropertiesJson {
    @JsonProperty("cd_id_fazenda")
    long cdIdFazenda;
    @JsonProperty("cd_id_talhao")
    long cdIdTalhao;
}
