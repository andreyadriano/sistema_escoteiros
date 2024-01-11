package engtelecom.bcd.lobinho.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"jovens"})
public class TipoSanguineo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSanguineo;

    @NonNull
    @Column(nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "tipoSanguineo")
    List<Jovem> jovens = new ArrayList<>();
}
