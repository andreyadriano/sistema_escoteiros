package engtelecom.bcd.lobinho.model.insignia;

import engtelecom.bcd.lobinho.model.Jovem;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"jovem", "requisito"})
@IdClass(ProgressaoInsigniaId.class)
public class ProgressaoInsignia {

    @NonNull
    @Column(nullable = false)
    private Date data;

    @Id
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_requisito_insignia")
    private RequisitoInsignia requisito;

    @Id
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_jovem")
    private Jovem jovem;

}
