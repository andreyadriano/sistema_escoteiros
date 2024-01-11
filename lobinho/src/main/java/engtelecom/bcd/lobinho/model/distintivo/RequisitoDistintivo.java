package engtelecom.bcd.lobinho.model.distintivo;

import engtelecom.bcd.lobinho.model.especialidade.ProgressaoEspecialidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"distintivo", "progressaoDistintivos"})
public class RequisitoDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequisitoDistintivo;

    @NonNull
    @Column(nullable = false)
    private String descricao;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_distintivo")
    private Distintivo distintivo;

    @OneToMany(mappedBy = "requisito")
    private List<ProgressaoDistintivo> progressaoDistintivos;

}
