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
@Table(name = "usuario")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cdId;
   private String nome;
}
