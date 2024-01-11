package engtelecom.bcd.lobinho.model.especialidade;

import engtelecom.bcd.lobinho.model.Jovem;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"jovem", "requisito"})
@IdClass(ProgressaoEspecialidadeId.class)
public class ProgressaoEspecialidade {

    @NonNull
    @Column(nullable = false)
    private Date data;

    @Id
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_requisito_especialidade")
    private RequisitoEspecialidade requisito;

    @Id
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_jovem")
    private Jovem jovem;

}
