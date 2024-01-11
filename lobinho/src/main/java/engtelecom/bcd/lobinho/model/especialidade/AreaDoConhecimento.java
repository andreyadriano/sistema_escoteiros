package engtelecom.bcd.lobinho.model.especialidade;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"especialidades"})
public class AreaDoConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "areaDoConhecimento")
    List<Especialidade> especialidades = new ArrayList<>();
}
