package engtelecom.bcd.lobinho.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"jovens"})
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlergia;

    @NonNull
    @Column(nullable = false)
    private String alergia;

    @ManyToMany(mappedBy = "alergias", fetch = FetchType.EAGER)
    private List<Jovem> jovens = new ArrayList<>();
}
