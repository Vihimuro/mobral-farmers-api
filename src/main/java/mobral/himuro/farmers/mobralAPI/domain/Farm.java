package mobral.himuro.farmers.mobralAPI.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "fazenda")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdId;

    private String nomeFazenda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_id_usuario")
    private User user;
}
