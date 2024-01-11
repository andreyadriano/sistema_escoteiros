package engtelecom.bcd.lobinho.model.insignia;

import engtelecom.bcd.lobinho.model.especialidade.ProgressaoEspecialidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"insignia", "progressaoInsignias"})
public class RequisitoInsignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequisitoInsignia;

    @NonNull
    @Column(nullable = false)
    private String descricao;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_insignia")
    private Insignia insignia;

    @OneToMany(mappedBy = "requisito")
    private List<ProgressaoInsignia> progressaoInsignias;
}
