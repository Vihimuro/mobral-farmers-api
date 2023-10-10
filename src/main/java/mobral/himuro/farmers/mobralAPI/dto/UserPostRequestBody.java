package mobral.himuro.farmers.mobralAPI.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserPostRequestBody {
    @NotEmpty(message = "Field 'nome' cannot be empty")
    private String nome;
}
