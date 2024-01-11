package engtelecom.bcd.lobinho.model.distintivo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"requisitos"})
public class Distintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistintivo;

    @NonNull
    @Column(nullable = false)
    private String progressao;

    @OneToMany(mappedBy = "distintivo")
    private List<RequisitoDistintivo> requisitos;

}
