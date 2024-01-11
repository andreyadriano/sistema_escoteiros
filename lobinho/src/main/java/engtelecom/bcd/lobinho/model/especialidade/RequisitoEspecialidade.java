package engtelecom.bcd.lobinho.model.especialidade;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"especialidade", "progressaoEspecialidades"})
public class RequisitoEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequisitoEspecialidade;

    @NonNull
    @Column(nullable = false)
    private String descricao;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "requisito")
    private List<ProgressaoEspecialidade> progressaoEspecialidades;
}
