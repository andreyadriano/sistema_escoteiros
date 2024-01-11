package engtelecom.bcd.lobinho.model.distintivo;

import engtelecom.bcd.lobinho.model.Jovem;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"jovem", "requisito"})
@IdClass(ProgressaoDistintivoId.class)
public class ProgressaoDistintivo {

    @NonNull
    @Column(nullable = false)
    private Date data;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_requisito_distintivo")
    private RequisitoDistintivo requisito;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_jovem")
    private Jovem jovem;
}
